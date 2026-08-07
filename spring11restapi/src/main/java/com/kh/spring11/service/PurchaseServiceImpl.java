package com.kh.spring11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring11.dao.CartDao;
import com.kh.spring11.dao.PurchaseDao;
import com.kh.spring11.dao.SaleDao;
import com.kh.spring11.dto.PurchaseDetailDto;
import com.kh.spring11.dto.PurchaseDto;
import com.kh.spring11.dto.SaleDto;
import com.kh.spring11.error.GetOutException;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;
import com.kh.spring11.vo.kakaopay.BuyVO;
import com.kh.spring11.vo.kakaopay.KakaopayApproveResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayCancelRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayCancelResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyResultVO2;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	private PurchaseDao purchaseDao;
	@Autowired
	private SaleDao saleDao;
	@Autowired
	private KakaopayService kakaopayService;
	@Autowired
	private CartDao cartDao;

	@Transactional
	@Override
	public void save(KakaopayApproveResponseVO payResponse, KakaopayReadyResultVO2 result) {
		
		
		//실 결제가 승인된 뒤 DB에 결제한 상품의 정보를 저장
				//[1] 대표정보 등록(번호는 준비단계에서 만들어서 partnerOrderId에 문자열 형태로 넣어뒀음)
				int purchaseNo = Integer.parseInt(payResponse.getPartnerOrderId());
				purchaseDao.purchaseInsert(
							PurchaseDto.builder()
								.purchaseNo(purchaseNo)
								.purchaseName(payResponse.getItemName())//상품명
								.purchaseTotal(payResponse.getAmount().getTotal())//구매금액
								.purchaseRemain(payResponse.getAmount().getTotal())//환불가능금액(=구매금액과 동일)
								.purchaseOwner(payResponse.getPartnerUserId())//구매자
								.purchaseTid(payResponse.getTid())
							.build()
						);
				//[2]상세정보등록
				List<BuyVO> orders = result.getOrders();
				for(BuyVO order : orders) {
					int purchaseDetailNo = purchaseDao.purchaseDetailSequence();
					SaleDto saleDto = saleDao.selectOne(order.getSaleNo());//상품 모든 정보 조회
					purchaseDao.purchaseDetailInsert(
							PurchaseDetailDto.builder()
								.purchaseDetailNo(purchaseDetailNo)//상세번호
								.purchaseDetailOrigin(purchaseNo)//대표번호
								.purchaseDetailItem(order.getSaleNo())//상품번호
								.purchaseDetailName(saleDto.getSaleName())//상품명 스냅샷
								.purchaseDetailPrice(saleDto.getSaleDiscountPrice())//상품가격 스냅샷
								.purchaseDetailQty(order.getQuantity())//수량
							.build()
							);
				}
				
				//[3]상품의 재고 차감
				//[4]장바구니의 내역 삭제(구매한 상품만)
//				cartDao.delete(구매자, 상품번호);
//				cartDao.delete(구매자, 상품번호들);
				cartDao.delete(
						payResponse.getPartnerUserId(),
						orders.stream().map(order->order.getSaleNo()).toList()
						);

		
	}
	@Transactional
	@Override
	public KakaopayCancelResponseVO cancelAll(
				int purchaseNo, TokenParseResponseVO parseVO) {
		//구매내역 조회 (TID를 얻어야 하니까)
		PurchaseDto purchaseDto = purchaseDao.selectOne(purchaseNo);
		
		//취소 불가능한 상황 제거
		if(purchaseDto == null) 
			throw new TargetNotfoundException();
		if(!purchaseDto.getPurchaseOwner().equals(parseVO.getAccountId()))
			throw new GetOutException();
		if(purchaseDto.getPurchaseStatus().equals("전체취소"))
			throw new GetOutException();
		if(purchaseDto.getPurchaseStatus().equals("차단"))
			throw new GetOutException();
		if(purchaseDto.getPurchaseRemain() == 0)
			throw new GetOutException();
		
		//DB처리
				//[1]구매 대표정보의 취소금액 변경 및 상태 변경 
				purchaseDao.purchaseCancel(purchaseNo);
				//[2]구매 대표정보와 연결된 구매 상세정보 항목들의 상태를 취소로 변경
				purchaseDao.purchaseDetailCancel(purchaseNo);
		
		//취소 요청
		KakaopayCancelResponseVO payResponse = kakaopayService.cancel(
			KakaopayCancelRequestVO.builder()
				.tid(purchaseDto.getPurchaseTid())//거래번호(TID)
				.cancelAmount(purchaseDto.getPurchaseRemain())//남은금액
			.build()
		);
		
		return payResponse;
	}

	

	//하나의 구매건중 하나의 상품의 취소(하나의 구매건에 갯수가 5개인데 이중 일부만 취소할 수는 없음)
	@Transactional
	@Override
	public KakaopayCancelResponseVO cancelUnit(int purchaseDetailNo, TokenParseResponseVO parseVO) {
		//[1]구매 상세 정보를 조회
		PurchaseDetailDto purchaseDetailDto = purchaseDao.selectDetailOne(purchaseDetailNo);
		if(purchaseDetailDto == null) throw new TargetNotfoundException();
		
		//[2]구매 대표 정보를 조회
		PurchaseDto purchaseDto = purchaseDao.selectOne(purchaseDetailDto.getPurchaseDetailOrigin());
		if(purchaseDto == null) throw new TargetNotfoundException();
		
		//security에서 검증이 안되는건 내가 해야됨. 꼼꼼하게 . 검증이 많으면 검증메소드를 따로 만들면됨. 
		
		//[3]취소 가능한 구매건인지 검증
		if(purchaseDetailDto.getPurchaseDetailStatus().equals("취소")) throw new GetOutException();
		System.out.println("purchaseDetailDto : "+ purchaseDetailDto);
		System.out.println("purchaseDto : "+ purchaseDto);
		if(purchaseDto.getPurchaseStatus().equals("전체취소")) throw new GetOutException();
		if(purchaseDto.getPurchaseStatus().equals("차단")) throw new GetOutException();
		if(purchaseDto.getPurchaseRemain() == 0) throw new GetOutException();
		if(!purchaseDto.getPurchaseOwner().equals(parseVO.getAccountId())) throw new GetOutException();
		
		int amount = purchaseDetailDto.getPurchaseDetailTotal();
		if(purchaseDto.getPurchaseRemain() < amount)//취소가능액이 상품금액보다 작다면
			throw new GetOutException();
		
		System.out.println("amount"+amount);
		
		
		//DB처리
		//[1] 구매 대표 정보의 취소 가능금액 차감 + 상태 재계산
		purchaseDao.purchaseCancelUnit(purchaseDto.getPurchaseNo(), amount);
		//[2] 구매 상세 정보의 상태를 취소로 변경 
		purchaseDao.purchaseDetailCancelUnit(purchaseDetailNo);
		
		
		
		
		
		
		//취소 요청(현재상품 금액만큼만 = 상품거래액 x 수량)
	
		
		KakaopayCancelResponseVO payResponseVO = kakaopayService.cancel(
				KakaopayCancelRequestVO.builder()
					.tid(purchaseDto.getPurchaseTid())
					.cancelAmount(amount)
				.build()
				);
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

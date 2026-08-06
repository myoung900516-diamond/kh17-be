package com.kh.spring11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
				

		
	}

	@Transactional
	@Override
	public KakaopayCancelResponseVO cancelAll(int purchaseNo, TokenParseResponseVO parseVO) {
		
		//구매내역 조회
		//tid를 얻어야 하니까
		PurchaseDto purchaseDto = purchaseDao.selectOne(purchaseNo);
		
		if(purchaseDto == null) throw new TargetNotfoundException();
		if(!purchaseDto.getPurchaseOwner().equals(parseVO.getAccountId())) throw new GetOutException();
		
		if(purchaseDto.getPurchaseStatus().equals("전체취소"))throw new GetOutException();
		if(purchaseDto.getPurchaseStatus().equals("차단"))throw new GetOutException();
		if(purchaseDto.getPurchaseRemain() == 0)throw new GetOutException();
		
		//DB처리
		purchaseDao.purchaseCancel(purchaseNo);
		
		
		//취소요청
		KakaopayCancelResponseVO payResponse = kakaopayService.cancel(
				KakaopayCancelRequestVO.builder()
				 	.tid(purchaseDto.getPurchaseTid())
				 	.cancelAmount(purchaseDto.getPurchaseRemain())
				.build()
				);
				
		
		return payResponse;
	}

	@Override
	public KakaopayCancelResponseVO cancelUnit(int purchaseDetailNo) {
		return null;
	}

}

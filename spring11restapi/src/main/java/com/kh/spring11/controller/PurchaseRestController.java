package com.kh.spring11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.AuthApiResponse;
import com.kh.spring11.annotation.CurrentUser;
import com.kh.spring11.dao.PurchaseDao;
import com.kh.spring11.dto.PurchaseDetailDto;
import com.kh.spring11.dto.PurchaseDto;
import com.kh.spring11.error.GetOutException;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.service.KakaopayService;
import com.kh.spring11.service.PurchaseService;
import com.kh.spring11.service.SaleService;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayCancelResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayOrderRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayOrderResponseVO;
import com.kh.spring11.vo.purchase.PurchaseHeavyInfoResponseVO;
import com.kh.spring11.vo.purchase.PurchaseInfoResponseVO;
import com.kh.spring11.vo.sale.SaleListItemVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name="결제 정보")
@AuthApiResponse
@Slf4j
@RestController
@RequestMapping("/api/purchase")
public class PurchaseRestController {
	
	@Autowired
	private PurchaseDao purchaseDao;
	
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private KakaopayService kakaopayService;
	
	@Autowired
	private PurchaseService purchaseService;
	
	//소유자 확인이 필요
	@ApiResponse(responseCode="200", description="결제 정보 조회 성공")
	@GetMapping("/simple/{purchaseNo}")
	public PurchaseInfoResponseVO find (
			@PathVariable int purchaseNo,
			@CurrentUser TokenParseResponseVO parseVO
			
			) {
		
		//구매 내역 조회
		PurchaseDto purchaseDto = purchaseDao.selectOne(purchaseNo);
		
		if(purchaseDto == null) throw new TargetNotfoundException(); //결제 정보가 없으면 404
		if(!purchaseDto.getPurchaseOwner().equals(parseVO.getAccountId()))
			throw new GetOutException(); //소유자가 아니면 403
		
		//상품 정보 추가 조회(구매내역 -> 구매상세내역 조회 -> 상품번호추출 -> 조회)
		
		
		List<PurchaseDetailDto> purchaseDetailList = purchaseDao.selectDetails(purchaseDto.getPurchaseNo());
		
		List<Integer> saleNumbers = purchaseDetailList.stream()
				.map(purchaseDetail -> purchaseDetail.getPurchaseDetailItem())
				.toList();
		
		List<SaleListItemVO> sales = saleService.findOrders(saleNumbers);
		
		return PurchaseInfoResponseVO.builder()
					.purchase(purchaseDto)
					.sales(sales)
				.build();
	}
	
	@ApiResponse(responseCode = "200", description = "결제정보(+카카오페이)조회 성공")
	@GetMapping(value = "/heavy/{purchaseNo}", produces="application/json")
	public PurchaseHeavyInfoResponseVO findWithKakao(
			@PathVariable int purchaseNo,
			@CurrentUser TokenParseResponseVO parseVO
			
			) {
		
		//구매내역 조회
		PurchaseDto purchaseDto = purchaseDao.selectOne(purchaseNo);
		if(purchaseDto == null) throw new TargetNotfoundException();//404
		if(!purchaseDto.getPurchaseOwner().equals(parseVO.getAccountId()))//403
			throw new GetOutException();
		
//		System.out.println("purchaseDto : " + purchaseDto);
//		System.out.println("parseVO : " + parseVO);
//		log.debug("purchaseDto : {}",  purchaseDto);
//		log.debug("parseVO : {}",  parseVO);
		
		//본인 소유이면서 존재하는 구매내역인 경우만 통과해서 온다
		//-상세내역+카카오페이조회내역을 가져온다
		
		//카카오페이 조회내역
		List<PurchaseDetailDto> details = purchaseDao.selectDetails(purchaseNo);
		
		KakaopayOrderResponseVO payResponse = kakaopayService.order(
				KakaopayOrderRequestVO.builder()
					.tid(purchaseDto.getPurchaseTid())//거래번호
				.build()
				
				);
		
		//응답 데이터 생성
		return PurchaseHeavyInfoResponseVO.builder()
					.purchase(purchaseDto)
					.details(details)
					.payResponse(payResponse)
				.build();
	}
	
	//구매건 전체취소
	@ApiResponse(responseCode="200", description="구매건 전체 취소 성공")
	@DeleteMapping("/cancelAll/{purchaseNo}")
	public void cancelAll(@PathVariable int purchaseNo,
			 @CurrentUser TokenParseResponseVO parseVO) {

		KakaopayCancelResponseVO payResponse = purchaseService.cancelAll(purchaseNo, parseVO);
		
	}

	//구매 상세건 취소 (부분취소)
//	@ApiResponse(responseCode="200", description="구매건 상세건 취소 성공")
//	@DeleteMapping("/cancelUnit/{purchaseDetailNo}")
//	public void cancelUnit(@PathVariable int purchaseDetailNo) {
//		KakaopayCancelResponseVO payResponse = purchaseService.cancelUnit(purchaseDetailNo);
//		
//	}
	
}

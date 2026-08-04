package com.kh.spring11.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.AuthApiResponse;
import com.kh.spring11.configuration.KakaopayProperties;
import com.kh.spring11.service.FlashService;
import com.kh.spring11.service.KakaopayService;
import com.kh.spring11.vo.kakaopay.KakaopayApproveRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayApproveResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayBuyRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayBuyResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyResultVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Tag(name="실험용 결제 API")
@AuthApiResponse
@RestController
@RequestMapping("/api/kakaopay/v1")
public class KakaopayRestControllerV1 {
	@Autowired
	private KakaopayService kakaopayService;
	
	@Autowired
	private KakaopayProperties kakaopayProperties;
	
	@Autowired
	private FlashService flashService;
	
	@ApiResponse(responseCode = "200", description="쓰건 아닌 실험용 결제 성공")
	@PostMapping(value = "/buy", produces="application/json")
	public KakaopayBuyResponseVO buy(KakaopayBuyRequestVO request){
//		보낼 데이터 통신은 기본적으로 String만 보낼 수 있음
		
		String partnerOrderId = UUID.randomUUID().toString();
		KakaopayReadyRequestVO payRequest = KakaopayReadyRequestVO.builder()
					.cid(kakaopayProperties.getCid())
					.partnerOrderId(partnerOrderId)
					.partnerUserId("testuser1")
					.itemName(request.getName())
					.totalAmount(request.getPrice())
					.approvalUrl("http://localhost:8080/api/kakaopay/v1/buy/success/"+partnerOrderId)
					.cancelUrl("http://localhost:8080/api/kakaopay/v1/buy/cancel/"+partnerOrderId)
					.failUrl("http://localhost:8080/api/kakaopay/v1/buy/fail/"+partnerOrderId)
				.build();
		
		KakaopayReadyResponseVO payResponse = kakaopayService.ready(payRequest);
		
		//결재 승인 요청 매핑에서 필요로 하는 데이터를 FlashService를 이용해서 저장한다. 
		flashService.addKakaopayReadyFlashData(
					KakaopayReadyResultVO.builder()
						.partnerOrderId(partnerOrderId)
						.partnerUserId(payRequest.getPartnerUserId())
						.tid(payResponse.getTid())
					.build()
				);
		
		return KakaopayBuyResponseVO.builder()
					.url(payResponse.getNextRedirectPcUrl())
				.build();
	}
	
	//결제의 결과에 따라 카카오페이가 불러주는 매핑
	
	@GetMapping("/buy/success/{partnerOrderId}")
//	@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
	public String success(
			@RequestParam(value="pg_token") String pgToken,
			@PathVariable String partnerOrderId
			){
//		log.debug("pg_token = "+ pgToken);
		
		//(Q)결제 승인요청을 이 곳에서 해야 하는데 필요한 정보 5개 중 1개밖에 없다. 
		//나머지 정보는 어디서 가져오지? 
		//-In memory storage 
		//	-1.직접 저장소를 구현 -> FlashService
		//	-2.Redis와 같은 인메모리DB사용 (윈도우에 설치 자체가 안됨)
		//(Q)결제 승인요청을 이 곳에서 해야 하는데 필요한 정보 5개 중 2개밖에 없다. 
		//나머지 정보는 어디서 가져오지? FlashService에서 찾아보자!
		KakaopayReadyResultVO result = flashService.getKakaopayReadyFlashData(partnerOrderId);
		
		
		
		//모인 데이터들로 승인 요청을 진행
		KakaopayApproveResponseVO payResponse = kakaopayService.approve(
					KakaopayApproveRequestVO.builder()
						.cid(kakaopayProperties.getCid())
						.tid(result.getTid())
						.partnerOrderId(result.getPartnerOrderId())
						.partnerUserId(result.getPartnerUserId())
						.pgToken(pgToken)
					.build()
				);
		
		return "결재완료!";
		
		
		
		
		
		
		
		
	}
//	@GetMapping("/but/success")
//	@GetMapping("/but/success")
	

}

package com.kh.spring11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring11.vo.kakaopay.KakaopayApproveRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayApproveResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KakaopayService {
	
	@Qualifier("kakaopayClient")
	@Autowired
	private WebClient webClient;
	

	//결제 준비
	public KakaopayReadyResponseVO ready(KakaopayReadyRequestVO request) {
		
//		상세주소 설정
		String url = "/online/v1/payment/ready";
		
//		(+추가) approvalUrl, cancelUrl, failUrl을 현재 페이지 주소를 알아내서 계산
//		String url = ServletUriComponentsBuilder
//				.fromCurrentContextPath() //현재 주소의 최상단에서 시작
//				.path("/member/cert") //추가 경로를 합치고
//				.queryParam("certEmail", memberEmail)
//				.queryParam("certNumber", number)
//				.toUriString(); //주소를 만드세요
		
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
		log.debug("context path = {} ", ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());
		log.debug("context request = {} ", ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
		log.debug("context request uri = {} ", ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString());
		log.debug("context servlet mapping = {} ", ServletUriComponentsBuilder.fromCurrentServletMapping().toUriString());
				
//		request.setApprovalUrl("http://localhost:8080/api/kakaopay/v1/buy/success");
//		request.setCancelUrl("http://localhost:8080/api/kakaopay/v1/buy/cancel");
//		request.setFailUrl("http://localhost:8080/api/kakaopay/v1/buy/fail");
		
		request.setApprovalUrl(baseUrl + "/success/" + request.getPartnerOrderId());
		request.setCancelUrl(baseUrl + "/cancel/" + request.getPartnerOrderId());
		request.setFailUrl(baseUrl + "/fail/" + request.getPartnerOrderId());
		
//		요청 발송 및 응답 수신
		KakaopayReadyResponseVO response = webClient.post()//	POST요청
				.uri(url)//상세주소
				.bodyValue(request)//첨부데이터
			.retrieve()//응답 수신 허용
				.bodyToMono(KakaopayReadyResponseVO.class)//일시불(Mono)로 수신 끝어서 받는건 Flux
				.block();//동기방식으로 수신
		
		return response;
	}
	
	//결제 승인
	public KakaopayApproveResponseVO approve(KakaopayApproveRequestVO request) {
		String url = "/online/v1/payment/approve";
				
				
		
				
		//		요청 발송 및 응답 수신
		KakaopayApproveResponseVO response = webClient.post()//	POST요청
				.uri(url)//상세주소
				.bodyValue(request)//첨부데이터
			.retrieve()//응답 수신 허용
				.bodyToMono(KakaopayApproveResponseVO.class)//일시불(Mono)로 수신 끝어서 받는건 Flux
				.block();//동기방식으로 수신
		
			
			return response;
	}
	
	
	

}

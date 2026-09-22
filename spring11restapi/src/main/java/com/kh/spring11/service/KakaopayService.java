package com.kh.spring11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring11.configuration.KakaopayProperties;
import com.kh.spring11.vo.kakaopay.KakaopayApproveRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayApproveResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayCancelRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayCancelResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayOrderRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayOrderResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KakaopayService {
	
	
	@Qualifier("kakaopayClient")
	@Autowired
	private WebClient webClient;
	
	@Autowired
	private KakaopayProperties kakaopayProperties;
	
//	@Autowired
//	private KakaopayReadyResultVO kakaopayReadyResultVO;
	
//	private final KakaopayProperties kakaopayProperties;
//	KakaopayService(KakaopayProperties kakaopayProperties){
//		this.kakaopayProperties = kakaopayProperties;
//	}

	//결제 준비
	public KakaopayReadyResponseVO ready(KakaopayReadyRequestVO request) {
//		System.out.println("request : " + request);
//		상세주소 설정
		String url = "/online/v1/payment/ready";

		
		request.setCid(kakaopayProperties.getCid());
//		System.out.println("request : " + request);
		
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();

		
		request.setApprovalUrl(baseUrl + "/success/" + request.getPartnerOrderId());
		request.setCancelUrl(baseUrl + "/cancel/" + request.getPartnerOrderId());
		request.setFailUrl(baseUrl + "/fail/" + request.getPartnerOrderId());
		System.out.println("request : " + request);
		
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
				
		request.setCid(kakaopayProperties.getCid());		
		
				
		//		요청 발송 및 응답 수신
		KakaopayApproveResponseVO response = webClient.post()//	POST요청
				.uri(url)//상세주소
				.bodyValue(request)//첨부데이터
			.retrieve()//응답 수신 허용
				.bodyToMono(KakaopayApproveResponseVO.class)//일시불(Mono)로 수신 끝어서 받는건 Flux
				.block();//동기방식으로 수신
		
			
			return response;
	}
	
	//결제조회
	public KakaopayOrderResponseVO order(KakaopayOrderRequestVO payRequest) {
		

		
		String url = "/online/v1/payment/order";
		
		payRequest.setCid(kakaopayProperties.getCid());
//		payRequest.setTid(kakaopayReadyResultVO.getTid());
		
		KakaopayOrderResponseVO response = webClient.post()//	POST요청
				.uri(url)//상세주소
				.bodyValue(payRequest)//첨부데이터
			.retrieve()//응답 수신 허용
				.bodyToMono(KakaopayOrderResponseVO.class)//일시불(Mono)로 수신 끝어서 받는건 Flux
				.block();
		
		return response;
	}
	
	//결제취소
	public KakaopayCancelResponseVO cancel(KakaopayCancelRequestVO payRequest) {
		
		String url = "/online/v1/payment/cancel";
		
		payRequest.setCid(kakaopayProperties.getCid());
//		payRequest.setTid(kakaopayReadyResultVO.getTid());//tid는 결제 승인 시점에 브라우저에서 주문번호를 받아와 purchaseDto에서 꺼내오는 것이다. 
		
		KakaopayCancelResponseVO payResponse = webClient.post()//	POST요청
				.uri(url)//상세주소
				.bodyValue(payRequest)//첨부데이터
			.retrieve()//응답 수신 허용
				.bodyToMono(KakaopayCancelResponseVO.class)//일시불(Mono)로 수신 끝어서 받는건 Flux
				.block();
		
		return payResponse;
	}
	

}

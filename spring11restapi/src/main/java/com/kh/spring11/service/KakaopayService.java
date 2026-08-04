package com.kh.spring11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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

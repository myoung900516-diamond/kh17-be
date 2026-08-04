package com.kh.spring11.kakaopay;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test02카카오페이승인요청 {
//	@Autowired
//	private WebClient webClient;
	
	@Test
	public void test() {
		//카카오페이 요청사항
//		POST /online/v1/payment/approve HTTP/1.1
//		Host: open-api.kakaopay.com
//		Authorization: SECRET_KEY ${SECRET_KEY}
//		Content-Type: application/json
		
//		전송 도구 준비
		WebClient webClient = WebClient.builder()
					.baseUrl("https://open-api.kakaopay.com")
					.defaultHeader("Authorization", "SECRET_KEY DEVD602E0FA02597B0855F8C4DB123A28702418A")
					.defaultHeader("Content-Type", "application/json")
				.build();	
		
//		상세주소 설정
		String url = "/online/v1/payment/approve";
		
		Map<String, String> body = new HashMap<>();
		
//		데이터설정
		body.put("cid", "TC0ONETIME");//가맹점 코드
		body.put("tid", "Ta714be626bf7fb4be96");
		body.put("partner_order_id", "10142ab4-3783-45a3-9092-dcf915db4914");
		body.put("partner_user_id", "testuser1");
		body.put("pg_token", "cc659d3e0bd55c66b357");
		
		
//		요청 발송 및 응답 수신
		Map response = webClient.post()//	POST요청
				.uri(url)//상세주소
				.bodyValue(body)//첨부데이터
			.retrieve()//응답 수신 허용
				.bodyToMono(Map.class)//일시불(Mono)로 수신 끝어서 받는건 Flux
				.block();//동기방식으로 수신
		
		
	}

}

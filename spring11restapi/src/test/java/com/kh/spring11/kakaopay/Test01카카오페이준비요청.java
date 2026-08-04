package com.kh.spring11.kakaopay;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test01카카오페이준비요청 {

	
	@Test
	public void test() {
		//kakao페이가 하라는데로 해야해요 아니면 안되요. 
		//할부도 단건결제에요. 정기결제가 정기 경제입니다. 구도같은 거요.
		
		//서버 메세징: 서버에서 서버로 메세지를 보내는 것 
		//[1] RestTemplate 사용 - Spring web 기본제공이지만 사용 빈도가 떨어진 추세(구조적 문제)
		//[2] WebClient 사용 - spring-webflux 모듈 필요 하지만 그 중에  WebClient만 사용할것.
		//뭐 보낼 내용이 동영상처럼 엄청 많은가? 
		
		//카카오페이 준비 요청을 보내보자
		
//		POST /online/v1/payment/ready HTTP/1.1
//		Host: open-api.kakaopay.com
//		
//		Authorization: SECRET_KEY ${SECRET_KEY}
//		Content-Type: application/json
		
//		http://open-api.kakaopay.com/online/v1/payment/ready: (내대답)
//		주소 - [POST] https://open-api.kakaopay.com/online/v1/payment/ready
//		헤더 - Authorization, Content-Type
		
//		전송 도구 준비
		WebClient webClient = WebClient.builder()
					.baseUrl("https://open-api.kakaopay.com")
					.defaultHeader("Authorization", "SECRET_KEY DEVD602E0FA02597B0855F8C4DB123A28702418A")
					.defaultHeader("Content-Type", "application/json")
				.build();	
		
//		상세주소 설정
		String url = "/online/v1/payment/ready";
		
//		보낼 데이터 통신은 기본적으로 String만 보낼 수 있음
		Map<String, String> body = new HashMap<>();
		body.put("cid", "TC0ONETIME");//가맹점 코드
		body.put("partner_order_id", UUID.randomUUID().toString());//가맹점 주문번호(주문을 구분하기 위한 고유번호)
		body.put("partner_user_id", "testuser1");//구매자 식별키 = account_id
		body.put("item_name", "이모티콘 10종세트 외 2건");//상품의 이름(결제할 때 쓰는 이름)
		body.put("quantity", "1");//상품 수량 (1로 통일 하고 db에서 관리)
		body.put("total_amount", "1000000");//결제금액(상품이 여러개면 합산한 금액)
		body.put("tax_free_amount", "0");//비과세액(면세점인 경우 해당)
//		아래 주소들은 반드시 카카오페이 개발자센터 플랫폼에 등록된 주소로 시작해야 한다. 
		body.put("approval_url", "http://localhost:8080/success");//성공시 연락받을 페이지 주소
		body.put("cancel_url", "http://localhost:8080/cancel");//취소시 연락받을 페이지 주소
		body.put("fail_url", "http://localhost:8080/fail");//실패시 연락받을 페이지 주소 
		
//		요청 발송 및 응답 수신
		Map response = webClient.post()//	POST요청
				.uri(url)//상세주소
				.bodyValue(body)//첨부데이터
			.retrieve()//응답 수신 허용
				.bodyToMono(Map.class)//일시불(Mono)로 수신 끝어서 받는건 Flux
				.block();//동기방식으로 수신
		
//		결과확인
		log.debug("partner_order_id = {}", body.get("partner_order_id"));
		log.debug("partner_user_id = {}", body.get("partner_user_id"));
		for(Object key : response.keySet()) {
			Object value = response.get(key);
			log.debug("{} = {}", key, value);
		}
		
	}

}

package com.kh.spring11.kakaopay;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import com.kh.spring11.configuration.KakaopayProperties;
import com.kh.spring11.vo.kakaopay.KakaopayOrderRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayOrderResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test03카카오페이조회요청2 {
	
	@Qualifier("kakaopayClient")
	@Autowired
	private WebClient webClient;
	
	@Autowired
	private KakaopayProperties kakaopayProperties;
	
	@Test
	public void test() {
//		상세주소 설정
		String url = "/online/v1/payment/order";
		
//		보낼 데이터 통신은 기본적으로 String만 보낼 수 있음
		KakaopayOrderRequestVO payRequest = KakaopayOrderRequestVO.builder()
					.cid(kakaopayProperties.getCid())
					.tid("Ta73e7af61000ca9eadd")
				.build();

		
//		요청 발송 및 응답 수신
		KakaopayOrderResponseVO response = webClient.post()//	POST요청 //조회는 설계상 get인데 편의상 post를 많이 씀 put이나 patch는 안씀 
				.uri(url)//상세주소
				.bodyValue(payRequest)//첨부데이터
			.retrieve()//응답 수신 허용
				.bodyToMono(KakaopayOrderResponseVO.class)//일시불(Mono)로 수신 끝어서 받는건 Flux
				.block();//동기방식으로 수신
		
//		for(Object key : response.keySet()) {
//			Object value = response.get(key);
//			log.debug("{} = {}", key, value);
//	}
	
		log.debug("response={}", response);

}
}

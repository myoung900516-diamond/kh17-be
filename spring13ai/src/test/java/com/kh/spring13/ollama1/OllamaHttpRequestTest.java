package com.kh.spring13.ollama1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
public class OllamaHttpRequestTest {
	
	@Test
	public void test() {
		//spring-reactive-web의 WebClient를 이용해서 구동중인 ollama 서버에 프롬프트를 전달하고 응답을 수신
		WebClient webClient = WebClient.builder()
					.baseUrl("http://localhost:11434")
				.build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

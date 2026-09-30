package com.kh.spring13.ollama2;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@SpringBootTest
public class SpringAiTest01 {
	
	@Test
	public void test() {
		//spring-ai에서 제공하는 객체들로 ollama server에 요청을 보내고 응답을 받자
		JdkClientHttpRequestFactory factory = new JdkClientHttpRequestFactory();
		factory.setReadTimeout(Duration.ofMinutes(5L));
		
		RestClient.Builder builder = RestClient.builder().requestFactory(factory);
		
		OllamaApi ollamaApi = OllamaApi.builder()
					.baseUrl("http://localhost:11434")
					.restClientBuilder(builder)
				.build();
		
		OllamaChatModel chatModel = OllamaChatModel.builder()
					.ollamaApi(ollamaApi)
					.options(
							OllamaChatOptions.builder()
								.model("qwen3:4b")
								.temperature(0.3)
								.disableThinking()
							.build()
							)
				.build();
		
		ChatClient chatClient = ChatClient.builder(chatModel).build();
		
		String response = chatClient
							.prompt()
								.system("너는 100세 할아버지야. 말 끝마다 '허허'라고 끝내야해.")//페르소나
								.user("AI가 뭐가 좋아?")
							.call().content();
		//(+추가)생각부분을 제거
		String endTag = "</think>";
		int position = response.indexOf("</think>");
		if(position >=0) {
			response = response.substring(position + endTag.length());
		}
		System.out.println(response.strip());
	}

}

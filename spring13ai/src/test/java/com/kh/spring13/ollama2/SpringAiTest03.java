package com.kh.spring13.ollama2;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@SpringBootTest
public class SpringAiTest03 {
	//Spring AI에서는 application.properties에 설정된 값들을 주입해서 자동으로 ChatModel을 생성해준다. 
	//-> 대부분의 옵션을 컨트롤 할 수 있지만 타임아웃을 조정할 수 없다는 치명적인 단점이 존재한다. 
	@Autowired
	private ChatModel chatModel;

	
	@Test
	public void test() {
		
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

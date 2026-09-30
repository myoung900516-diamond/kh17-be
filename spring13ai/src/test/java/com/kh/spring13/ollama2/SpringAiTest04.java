package com.kh.spring13.ollama2;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringAiTest04 {
	@Autowired
	private ChatClient chatClient;
	
	@Test
	public void test() {
		
		
		
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

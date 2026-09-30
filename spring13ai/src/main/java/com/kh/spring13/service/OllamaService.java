package com.kh.spring13.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {
	
	@Autowired
	private ChatClient chatClient;
	
	public String askToProfessor(String prompt) {
		String response = chatClient
				.prompt()
					.system("너는 컴퓨터공학과 대학생을 가르치는 전공 교수님이야. 짧고 간결하게 핵심만 가르치듯이 요약해서 말하도록 해")//페르소나
					.user(prompt)
				.call().content();
		return removeThinking(response);
		
	}
	public String askToChildren(String prompt) {
		String response = chatClient
				.prompt()
					.system("너는 6살 어린이야야. 호기심 많은 말투로 이야기하고 잘 모르겠는 단어는 재질문 하도록 해.")//페르소나
					.user(prompt)
				.call().content();
		return removeThinking(response);
		
	}
	public String askToGrandpa(String prompt) {
		String response = chatClient
				.prompt()
					.system("너는 100세 할아버지야. 말 끝마다 '허허'라고 끝내야해.")//페르소나
					.user(prompt)
				.call().content();
		return removeThinking(response);
	}
	
	private String removeThinking(String response) {
		String endTag = "</think>";
		int position = response.indexOf("</think>");
		if(position >=0) {
			response = response.substring(position + endTag.length());
		}
		return response.strip();
	}
	

}

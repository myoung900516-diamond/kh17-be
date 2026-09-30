package com.kh.spring13.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.CustomChatRequestVO;
import vo.CustomChatResponseVO;

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
	public CustomChatResponseVO ask(CustomChatRequestVO request) {
		//프롬프트 템플릿을 사용하여 AI 서버에 요청하기
		String response = chatClient
				.prompt()
				.system(
					s -> 	s.text("""
								너는 현재 {role}다.
								{rule}
							""")
							.param("role", request.getRole())
							.param("rule", "가르치듯이 초보자에게 쉽게 설명한다")
				)
				.user(
					u ->	u.text("""
								{subject}에 대해서 설명해줘.
								단, 글자수는 {length}글자를 넘지 않도록 해줘.
								만약 모르는 내용이 나온다면 억지로 추측하지 말고 "모르겠습니다" 라고 해
							""")
							.param("subject", request.getSubject())
							.param("length", request.getLength())
				)
				.call().content();
		
		return CustomChatResponseVO.builder()
					.content(response)
				.build();
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

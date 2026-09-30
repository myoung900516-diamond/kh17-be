package com.kh.spring13.ollama2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring13.service.OllamaService;

@SpringBootTest
public class SpringAiTest05 {
	@Autowired
	private OllamaService ollamaService;
	
	@Test
	public void test() {
		
		
		
		String response = ollamaService.askToProfessor("AI가 뭐가 좋아?");
//		String response = ollamaService.askToGrandpa("AI가 뭐가 좋아?");
//		String response = ollamaService.askToChildren("AI가 뭐가 좋아?");
		
		
		System.out.println(response);
	}

}

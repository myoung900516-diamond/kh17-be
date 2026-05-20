package com.kh.spring09.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class Test01이메일보내기2 {

	@Autowired
	private JavaMailSender sender;//생성과 사용이 구분되어서 //이래도 사용가능함 
	
	
	@Test
	public void test() {
		
		
		
		SimpleMailMessage message = new SimpleMailMessage();
		
//		message.setFrom("kh.kmy0226@gmail.com");
		message.setTo("sophie0516@naver.com");
		message.setText("보낼 내용");
		message.setSubject("테스트 이메일");
	
		
		
		sender.send(message);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

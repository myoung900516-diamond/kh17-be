package com.kh.spring09.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test03마임메세지 {
	
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException {
		
//		MimeMessage message = new MimeMessage(???);
		MimeMessage message = sender.createMimeMessage();
		
		
		MimeMessageHelper helper = 
					new MimeMessageHelper(message, false, "UTF-8");
		
//		helper.setFrom("khkmy0226@gmail.com");
		helper.setTo(new String[] {"sophie0516@naver.com"});//여러명일 때
		helper.setSubject("마임메세지 연습");
		helper.setText("<h1>반가워</h1>", true);
		
		sender.send(message);
		
		
	}
}

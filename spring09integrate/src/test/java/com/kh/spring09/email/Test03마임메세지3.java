package com.kh.spring09.email;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.kh.spring09.service.EmailService;
import com.kh.spring09.service.RandomService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test03마임메세지3 {
	
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private EmailService emailService;
	@Autowired
	private RandomService randomService;
	
	@Test
	public void test() throws MessagingException, IOException {
		
		MimeMessage message = sender.createMimeMessage();
		
		
		MimeMessageHelper helper = 
					new MimeMessageHelper(message, false, "UTF-8");
		
		helper.setTo(new String[] {"sophie0516@naver.com"});//여러명일 때
		helper.setSubject("[KH정보교육원] 인증번호테스트");
		

		String certNumber = randomService.generateNumber(6);
		
		String template = emailService.createCertHtml(certNumber);
		
		helper.setText(template, true);
		
		sender.send(message);
		
		
	}
}

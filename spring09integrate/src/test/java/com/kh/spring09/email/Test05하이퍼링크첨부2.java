package com.kh.spring09.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test05하이퍼링크첨부2 {

	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException {
		//마임메세지에 <a>를 넣는 방법
		//상대경로면 절대 안됨 차단당함
		//무조건 절대경로만 가능(http~~)
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		helper.setTo("sophie0516@naver.com");
		helper.setSubject("링크첨부 테스트");
		
		String url = "";
		
		String html = "<a href='"+url+"'>google</a>";
		
		helper.setText(html, true);
		
		sender.send(message);
	}
}

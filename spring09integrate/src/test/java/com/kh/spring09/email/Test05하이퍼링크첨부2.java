package com.kh.spring09.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		
		
		//(주의) 테스트나 비동기 환경에서는 주소가 정상적으로 안 생김
		//실제 환경에서 실행시켜야해요.
		String url = ServletUriComponentsBuilder
						.fromCurrentContextPath() //현재 주소의 최상단에서 시작
						.path("/member/join") //추가 경로를 합치고
						.toUriString(); //주소를 만드세요
		
		String html = "<a href='"+url+"'>회원가입</a>";
		
		helper.setText(html, true);
		
		sender.send(message);
	}
}

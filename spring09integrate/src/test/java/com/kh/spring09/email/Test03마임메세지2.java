package com.kh.spring09.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.kh.spring09.service.RandomService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test03마임메세지2 {
	
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private RandomService randomService;
	
	@Test
	public void test() throws MessagingException {
		
//		MimeMessage message = new MimeMessage(???);
		MimeMessage message = sender.createMimeMessage();
		
		
		MimeMessageHelper helper = 
					new MimeMessageHelper(message, false, "UTF-8");
		
//		helper.setFrom("khkmy0226@gmail.com");
		helper.setTo(new String[] {"sophie0516@naver.com"});//여러명일 때
		helper.setSubject("[KH정보교육원] 인증번호테스트");
		
		String certNumber = randomService.generateNumber(6);
		StringBuffer buffer = new StringBuffer();
		buffer.append("<div>");
		buffer.append("<h2>인증번호 안내</h2>");
		buffer.append("다음 표시되는 인증번호를 인증번호 입력창에 작성하세요");
		buffer.append("<div style=\"display: flex; font-size: 30px; font-weight: bold; margin-top: 40px;\">");
		buffer.append("<div style=\"width: 50px; height: 50px; margin-right: 10px; display: flex; justify-content: center; align-items: center;\">"+certNumber.charAt(0)+"</div>");
		buffer.append("<div style=\"width: 50px; height: 50px; margin-right: 10px; display: flex; justify-content: center; align-items: center;\">"+certNumber.charAt(1)+"</div>");
		buffer.append("<div style=\"width: 50px; height: 50px; margin-right: 10px; display: flex; justify-content: center; align-items: center;\">"+certNumber.charAt(2)+"</div>");
		buffer.append("<div style=\"width: 50px; height: 50px; margin-right: 10px; display: flex; justify-content: center; align-items: center;\">"+certNumber.charAt(3)+"</div>");
		buffer.append("<div style=\"width: 50px; height: 50px; margin-right: 10px; display: flex; justify-content: center; align-items: center;\">"+certNumber.charAt(4)+"</div>");
		buffer.append("<div style=\"width: 50px; height: 50px; margin-right: 10px; display: flex; justify-content: center; align-items: center;\">"+certNumber.charAt(5)+"</div>");
		buffer.append("</div>");
		buffer.append("</div>");
		
		
		helper.setText(buffer.toString(), true);
		
		
	    
		
		sender.send(message);
		
		
	}
}

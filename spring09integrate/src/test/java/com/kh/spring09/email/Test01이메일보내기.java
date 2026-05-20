package com.kh.spring09.email;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
public class Test01이메일보내기 {

	
	
	
	@Test
	public void test() {
		//1. 메일 전송 도구 생성
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		//+메일 전송 도구의 정보 설정
		sender.setHost("smtp.gmail.com");//이용할 업체의 호스트 정보
		sender.setPort(587);//이용할 업체의 포트 번호
		sender.setUsername("kh.kmy0226");//이용자의 계정이름
		sender.setPassword("gatulhrwrjcprkuj");//이용자의 앱비밀번호

		Properties props = new Properties();//Map<String, String>형태
		props.setProperty("mail.smtp.auth", "true");//인증 사용
		props.setProperty("mail.smtp.debug", "true");//에러 시 통신내역 출력(운영단계에서는 false 너무 많은 에러가 나오니까)
		props.setProperty("mail.smtp.starttls.enable", "true");//보안 protocol
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");//보안 프로토콜 버전을 최신으로 지정 
		props.setProperty("mail.smtp.trust", "smtp.gmail.com");//신뢰할 수 있는 업체 목록에 추가 
		sender.setJavaMailProperties(props);
		
		
		//2. 메세지 생성
		SimpleMailMessage message = new SimpleMailMessage();
		
		//+메세지 내용 작성
//		message.setFrom("kh.kmy0226@gmail.com");//전송안되면 이것까지 쓰기 
		message.setTo("sophie0516@naver.com");
//		message.setCc(null);
//		message.setBcc(null);
		message.setText("보낼 내용");
		message.setSubject("신기하당");
	
		
		
		//3. 전송
		sender.send(message);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

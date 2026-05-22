package com.kh.spring09.email;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test04첨부파일 {

	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setTo("sophie0516@naver.com");
		helper.setSubject("파일첨부테스트");
		helper.setText("테스트내용", false);
		
//		helper.addAttachment("상대에게 보여질 파일 이름", 실제파일또는스트림또는multipartfile);
		
		File file = new File("D:/diamond.png");
		if(!file.exists()) return;
		
		FileSystemResource resource = new FileSystemResource(file);
		ClassPathResource resource2 = 
				new ClassPathResource("static/images/kh.jpg");
		
		helper.addAttachment("첨부파일1번.png", resource);
		helper.addAttachment("첨부파일2번.jpg", resource2);
		
		sender.send(message);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

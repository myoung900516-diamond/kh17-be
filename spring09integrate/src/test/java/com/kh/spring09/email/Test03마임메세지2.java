package com.kh.spring09.email;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
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
	public void test() throws MessagingException, IOException {
		
//		MimeMessage message = new MimeMessage(???);
		MimeMessage message = sender.createMimeMessage();
		
		
		MimeMessageHelper helper = 
					new MimeMessageHelper(message, false, "UTF-8");
		
//		helper.setFrom("khkmy0226@gmail.com");
		helper.setTo(new String[] {"sophie0516@naver.com"});//여러명일 때
		helper.setSubject("[KH정보교육원] 인증번호테스트");
		
//		미리 만들어둔 templates/cert-template.html을 읽어들여서 전송
//		-Spring은 두 가지의 경로를 제공한다 (filepath, classpath)
//		-filepath는 프로젝트 전체에서의 경로 (최종 배포파일과는 무관)
//		-classpath는 src 내부의 경로(최종 배포파일에서도 동일)
		
		ClassPathResource resource = new ClassPathResource("templates/cert-template.html");
		
		File target = resource.getFile();
//		전송할 번호 생성		
		String certNumber = randomService.generateNumber(6);
//		파일 읽을 준비
		BufferedReader reader = new BufferedReader(new FileReader(target));
		
		StringBuffer buffer = new StringBuffer();
//		한줄 씩 읽어와서 합성
		while(true){
			String line = reader.readLine();//한줄을 읽어서
			if(line == null) break;
			buffer.append(line);
		}
		reader.close();
		
//		임기응변 : 문자열 치환명령으로 #1~#6까지 찾아서 번호로 교체 
		String html = buffer.toString();
		
//		jsoup 기술을 이용해서 문자열을 html로 변환한 뒤 원하는 태그를 찾아 변조
//		Document document = Jsoup.parse(html);
		
//		Elements list = document.select(".number-wrapper");//class=number-wrapper인 항목을 찾아
		
//		for(int i=0; i<list.size(); i++) {
//			Element tag = list.get(i);//태그 정보를 얻어내서
//			char ch = certNumber.charAt(i);//인증번호 한 자리를 뽑아서
//			tag.text(String.valueOf(ch));//설정
//		}
		
		
		  html = html.replace("#1", certNumber.substring(0, 1)); 
		  html = html.replace("#2", certNumber.substring(1, 2)); 
		  html = html.replace("#3", certNumber.substring(2, 3)); 
		  html = html.replace("#4", certNumber.substring(3, 4)); 
		  html = html.replace("#5", certNumber.substring(4, 5)); 
		  html = html.replace("#6", certNumber.substring(5, 6));
		
		
//		StringBuffer buffer = new StringBuffer();
//		buffer.append("<div>");
//		buffer.append("<h2>인증번호 안내</h2>");
//		buffer.append("다음 표시되는 인증번호를 인증번호 입력창에 작성하세요");
//		buffer.append("<div style=\"display: flex; font-size: 30px; font-weight: bold; margin-top: 40px;\">");
//		buffer.append("<div style=\"width: 50px; height: 50px; margin-right: 10px; display: flex; justify-content: center; align-items: center;\">"+certNumber.charAt(0)+"</div>");
//		buffer.append("<div style=\"width: 50px; height: 50px; margin-right: 10px; display: flex; justify-content: center; align-items: center;\">"+certNumber.charAt(1)+"</div>");
//		buffer.append("<div style=\"width: 50px; height: 50px; margin-right: 10px; display: flex; justify-content: center; align-items: center;\">"+certNumber.charAt(2)+"</div>");
//		buffer.append("<div style=\"width: 50px; height: 50px; margin-right: 10px; display: flex; justify-content: center; align-items: center;\">"+certNumber.charAt(3)+"</div>");
//		buffer.append("<div style=\"width: 50px; height: 50px; margin-right: 10px; display: flex; justify-content: center; align-items: center;\">"+certNumber.charAt(4)+"</div>");
//		buffer.append("<div style=\"width: 50px; height: 50px; margin-right: 10px; display: flex; justify-content: center; align-items: center;\">"+certNumber.charAt(5)+"</div>");
//		buffer.append("</div>");
//		buffer.append("</div>");
//		
//		
//		helper.setText(buffer.toString(), true);
		helper.setText(html, true);//HTML모드
//		helper.setText(document.toString(), true);
		
		
	    
		
		sender.send(message);
		
		
	}
}

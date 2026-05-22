package com.kh.spring09.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring09.dao.CertDao;
import com.kh.spring09.dto.CertDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private RandomService randomService;
	@Autowired
	private CertDao certDao;
	
	
	//이 메소드는 이제부터 비동기
	@Async
	public void sendWelcomeMail(String memberEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(memberEmail);
		message.setSubject("[KH정보교육원] 가입을 진심으로 환영합니다!");
		message.setText("앞으로도 많은 활동 부탁드립니다");
		sender.send(message);
	}
	
	
	//인증번호 발송 메소드 (단문메일용)
	public void sendCertNumber(String memberEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(memberEmail);
		message.setSubject("이메일 인증코드가 도착하였습니다.");
		
//		Random r = new Random();
//		int number = r.nextInt(1000000);
//		Format f = new DecimalFormat("000000");
		
		String number = randomService.generateNumber(6);
		
		
//		message.setText("인증번호는 ["+f.format(number)+"]입니다. \n 입력창에 입력 후 확인을 눌러주세요");
		message.setText("인증번호는 ["+number+"]입니다. \n 입력창에 입력 후 확인을 눌러주세요");
		
		sender.send(message);

		CertDto certDto = certDao.selectOne(memberEmail);
		if(certDto == null) {
			certDao.insert(CertDto.builder()
						.certEmail(memberEmail)
						.certNumber(number)
					.build());			
		}
		else {
			certDao.update(CertDto.builder()
					.certEmail(memberEmail)
					.certNumber(number)
				.build());	
		}
	}
	//인증번호 발송 메소드(마임메세지용)
	public void sendCertNumber2(String memberEmail) throws MessagingException, IOException {
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		helper.setTo(memberEmail);
		helper.setSubject("[KH정보교육원] 인증 코드가 도착하였습니다");
		

		String number = randomService.generateNumber(6);
		
		String template = this.createCertHtml(number);
		
		helper.setText(template, true);
		
		sender.send(message);
		
		CertDto certDto = certDao.selectOne(memberEmail);
		if(certDto == null) {
			certDao.insert(CertDto.builder()
						.certEmail(memberEmail)
						.certNumber(number)
					.build());			
		}
		else {
			certDao.update(CertDto.builder()
					.certEmail(memberEmail)
					.certNumber(number)
				.build());	
		}
		
		
	}
	//인증용 링크 발송 메소드
	public void sendCertLink(String memberEmail) throws MessagingException{
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		helper.setTo(memberEmail);
		helper.setSubject("이메일 인증링크가 도착하였습니다");
		
		String number = randomService.generateNumber(6);
		
		String url = ServletUriComponentsBuilder
				.fromCurrentContextPath() //현재 주소의 최상단에서 시작
				.path("/member/cert") //추가 경로를 합치고
				.queryParam("certEmail", memberEmail)
				.queryParam("certNumber", number)
				.toUriString(); //주소를 만드세요

		String html = "<h2><a href='"+url+"'>이메일인증완료하기</a></h2>";
		
		helper.setText(html, true);
		
		sender.send(message);
		
		CertDto certDto = certDao.selectOne(memberEmail);
		if(certDto == null) {
			certDao.insert(CertDto.builder()
						.certEmail(memberEmail)
						.certNumber(number)
					.build());			
		}
		else {
			certDao.update(CertDto.builder()
					.certEmail(memberEmail)
					.certNumber(number)
				.build());	
		}
	}
	
	public String createCertHtml(String certNumber) throws IOException {
		ClassPathResource resource = 
				new ClassPathResource("templates/cert-template.html");
		
		File target = resource.getFile();
//		전송할 번호 생성		
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
		Document document = Jsoup.parse(html);
		
		Elements list = document.select(".number-wrapper");//class=number-wrapper인 항목을 찾아
		
		for(int i=0; i<list.size(); i++) {
			Element tag = list.get(i);//태그 정보를 얻어내서
			char ch = certNumber.charAt(i);//인증번호 한 자리를 뽑아서
			tag.text(String.valueOf(ch));//설정
		}
		return document.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

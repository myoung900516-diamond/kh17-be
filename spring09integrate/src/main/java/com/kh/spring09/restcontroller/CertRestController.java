package com.kh.spring09.restcontroller;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.CertDao;
import com.kh.spring09.dto.CertDto;
import com.kh.spring09.service.EmailService;

import jakarta.mail.MessagingException;

@CrossOrigin
@RestController
@RequestMapping("/rest/cert")
public class CertRestController {
	@Autowired
	private EmailService emailService;
	@Autowired
	private CertDao certDao;
	
	
	@PostMapping("/send")
	public void send(@RequestParam String certEmail) throws MessagingException, IOException {
//		emailService.sendCertNumber2(certEmail);
		emailService.sendCertNumber2(certEmail);
//		emailService.sendCertLink(certEmail);
		
		
	}
	@PostMapping("/check")
	public boolean check(@ModelAttribute CertDto certDto) {
		//1. 정보가 있는지 확인
		CertDto findDto = certDao.selectOne(certDto.getCertEmail());
		//if(findDto == null) throw new WhoAreYouException(); //ajax가면 error로 처리
		if(findDto == null) return false; //ajax가면 true or false로 처리
//		System.out.println(findDto);
//		System.out.println(certDto);
		//2. 번호가 맞는지 확인 
		boolean valid = certDto.getCertNumber().equals(findDto.getCertNumber());
		if(valid == false) return false;
//		System.out.println(valid);
		//3. 시간이 안지났는지 확인
		//현재시간이랑 보낸시간을 비교해봐야함 
		LocalDateTime current = LocalDateTime.now();//현재시각
		LocalDateTime sent = findDto.getCertTime().toLocalDateTime();//보낸시간
		
		Duration duration = Duration.between(sent, current);
		if(duration.toMinutes() > 10) {
			return false;
		}
		
		//4.인증 가능한 상태인지 확인(cert_yn='N')
//		if(findDto.getCertYn().equals("Y")) {
		if(findDto.isComplete()) 
			
			return false;
			
//		System.out.println(findDto.isComplete());
		
		
//		certDao.delete(certDto.getCertEmail());//사용한 인증번호 기록을 지우자! 
		certDao.update(certDto.getCertEmail());
		return true;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

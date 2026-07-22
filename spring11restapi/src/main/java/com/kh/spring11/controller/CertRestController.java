package com.kh.spring11.controller;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.CommonsApiResponse;
import com.kh.spring11.dao.CertDao;
import com.kh.spring11.dto.CertDto;
import com.kh.spring11.service.EmailService;
import com.kh.spring11.vo.cert.CertCheckRequestVO;
import com.kh.spring11.vo.cert.CertCheckResponseVO;
import com.kh.spring11.vo.cert.CertSendRequestVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;

@Tag(name="이메일 발송 서비스")
@CommonsApiResponse

//@CrossOrigin
@RestController
@RequestMapping("/service/cert")
public class CertRestController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private CertDao certDao;
	
	@ApiResponse(responseCode="200", description="이메일발송성공")
	@PostMapping("/send")
	public void send(@RequestBody CertSendRequestVO vo) throws MessagingException, IOException {
		 emailService.sendCertNumber2(vo.getCertEmail());
		
		
	}
	@ApiResponse(responseCode="200", description="이메일검사성공")
	@PostMapping(value ="/check", produces="application/json")
	public CertCheckResponseVO check(@RequestBody CertCheckRequestVO vo) {
		
			//1. 정보가 있는지 확인
			CertDto findDto = certDao.find(vo.getCertEmail());
			if(findDto == null) 
				return CertCheckResponseVO.builder()
						.valid(false)
					.build(); //ajax가면 true or false로 처리
			//2. 번호가 맞는지 확인 
			boolean valid = vo.getCertNumber().equals(findDto.getCertNumber());
			if(valid == false) {
				return CertCheckResponseVO.builder()
					.valid(false)
				.build();
				}
			//3. 시간이 안지났는지 확인
			//현재시간이랑 보낸시간을 비교해봐야함 
			LocalDateTime current = LocalDateTime.now();//현재시각
			LocalDateTime sent = findDto.getCertTime().toLocalDateTime();//보낸시간
			
			Duration duration = Duration.between(sent, current);
			if(duration.toMinutes() > 10) {
				return CertCheckResponseVO.builder()
						.valid(false)
					.build();
			}
			
			//4.인증 가능한 상태인지 확인(cert_yn='N')
			if(findDto.isComplete()) 
				
				return CertCheckResponseVO.builder()
						.valid(false)
					.build();;
				
			
			
			certDao.use(vo.getCertEmail());
			return CertCheckResponseVO.builder()
					.valid(true)
				.build();
			
		}
		
	}
	
	
	
	
	
	



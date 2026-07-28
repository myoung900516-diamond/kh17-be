package com.kh.spring11.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.spring11.configuration.LoginProperties;
import com.kh.spring11.dao.AccountDao;
import com.kh.spring11.dto.AccountDto;
import com.kh.spring11.error.GetOutException;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.auth.AuthLoginRequestVO;
import com.kh.spring11.vo.auth.AuthLoginResponseVO;

import lombok.extern.slf4j.Slf4j;

//인증과 관련된 복잡한 작업들을 모듈화 하여 처리하기 위한 서비스
@Slf4j
@Service
public class AuthService {
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginProperties loginProperties;
	
	
	//로그인 처리
	public AuthLoginResponseVO login(AuthLoginRequestVO request) {
		//아이디에 해당하는 회원 조회
		AccountDto accountDto = accountDao.selectOne(request.getAccountId());
		if(accountDto == null) {
//			log.error("아이디가 존재하지 않습니다");
			throw new TargetNotfoundException();
		}
		//비밀번호 비교
		boolean valid = passwordEncoder.matches(
					request.getAccountPassword(), 
					accountDto.getAccountPassword()
				);
		if(valid == false) {
//			log.error("비밀번호가 일치하지 않습니다");
			throw new TargetNotfoundException();
		}
		//차단된 회원이라면?
		if(accountDto.getAccountBlock().equals("Y")) {
			
			throw new GetOutException();
		}
		
		//비밀번호 변경이 오래되었는지 판정
		//-설정파일의 need-update-term보다 변경일이 오래되어야 한다.(=초과)
		Timestamp lastChange = accountDto.getAccountChange();
		if(lastChange == null) {//한번도 바꾼 적이 없는 경우(가입일과 비교)
			lastChange = accountDto.getAccountJoin();
		}
		LocalDateTime lastTime = lastChange.toLocalDateTime();
		LocalDateTime current = LocalDateTime.now();
		
		long days = ChronoUnit.DAYS.between(lastTime, current);
		
		boolean needUpdate= days >= loginProperties.getNeedUpdateterm();
		
		
		//비밀번호를 생성한지 30일이 지났으면 needUpdate를 true로 변환
//				Timestamp changed = accountDto.getAccountChange();
//				if(changed != null) {
//					LocalDateTime at = changed.toLocalDateTime();
//					LocalDateTime now = LocalDateTime.now();
//					if( at.plusDays(30).isBefore(now)) {
//						response.setNeedUpdate(true);
//					}
//				}
		
		
//		log.debug("로그인성공");
		//로그인 성공 
		return AuthLoginResponseVO.builder()
				.accountId(accountDto.getAccountId())
				.accountLevel(accountDto.getAccountLevel())
				.accountNickname(accountDto.getAccountNickname())
				.needUpdate(needUpdate)
			.build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

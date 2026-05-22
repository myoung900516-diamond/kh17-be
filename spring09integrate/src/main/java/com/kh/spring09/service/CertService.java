package com.kh.spring09.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kh.spring09.dao.CertDao;

//인증과 관련된 처리를 하는 서비스
@Service
public class CertService {
	
	@Autowired
	private CertDao certDao;
	
	//스케쥴링 메소드
	//-cron 표현식으로 디테일하게 지정(초/분/시/일/월/요일/연)
	//-*은 every 값을 의미 (매초, 매분, 매시, 매일, 매월, 매요일)
	//- 나누기(/)는 패턴을 의미 (ex, */5 = 5초마다
	//- 범위는 ~대신 -를 사용
	//- 요일은 월(1) ~ 일(7)로 작성하거나 영어도 가능 월(MON)~ 일(SUN);
	//- 일과 요일은 서로 충돌이 생기는 경우가 많음.. 무관(?)으로 설정을 하는 것이 좋다
	//- ?:any, *:every
//	@Scheduled(fixedRate = 1000L)//1000밀리초마다 실행=1초
//	@Scheduled(cron = "* * * * * *")
	@Scheduled(cron = "0 0 * * * *")
//	@Scheduled(cron = "0 0 9-18 ? * 1-5")
	
//	출근 시점과 퇴근 시점에만 실행되도록 스케쥴 설정(콤마 사용)
//	@Scheduled(cron = "0 0 9,18 ? * 1-5")
//	특정주차를 언급하여 실행할 수 있음(ex:두번째 주 수요일)
//	@Scheduled(cron = "0 0 0 ? * 3#2")
//	@Scheduled(cron = "0 0 0 ? * 3L")//마지막 주 수요일
//	22일과 가장 가까운 평일(22일이 평일이면 22일에 실행, 토요일이면 21일, 일요일이면 23일이 )
//	@Scheduled(cron = "0 0 * 22W * ?")
	public void clear() {
		System.out.println("청소시작! "+ LocalDateTime.now());
		certDao.clear(10, 30);
	}
	
	
}

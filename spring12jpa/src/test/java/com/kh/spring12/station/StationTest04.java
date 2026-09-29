package com.kh.spring12.station;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Station;
import com.kh.spring12.error.TargetNotfoundException;
import com.kh.spring12.repo.StationRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class StationTest04 {
	
	@Autowired
	private StationRepository stationRepository;
	
	@Test
	public void test() {
		Station station = Station.builder().stationNo(1L).stationName("역삼역(KH정보교육원)").location("서울시 강남구 역삼동1StationTest03.java").build();

		//영속 객체 조회
		Station target = stationRepository.findById(station.getStationNo())
				.orElseThrow(TargetNotfoundException::new);
		
		//정보 치환 후 수정 처리
		target.setStationName(station.getStationName());//역명 복사
		target.setLocation(station.getLocation());//지역 복사
		
		//수정(=등록, 단 ID가 존재해야함)
		stationRepository.save(target);
	}

}

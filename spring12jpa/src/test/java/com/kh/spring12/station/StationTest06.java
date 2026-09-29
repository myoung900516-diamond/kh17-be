package com.kh.spring12.station;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Station;
import com.kh.spring12.error.TargetNotfoundException;
import com.kh.spring12.repo.StationRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class StationTest06 {
	
	@Autowired
	private StationRepository stationRepository;
	
	@Test
	@Transactional
	public void test() {
		long stationNo= 1L;
		//영속 객체 조회
		Station target = stationRepository.findById(stationNo)
				.orElseThrow(TargetNotfoundException::new);
		
		
		
		//삭제
		stationRepository.delete(target);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

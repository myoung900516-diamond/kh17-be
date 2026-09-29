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
public class StationTest03 {
	
	@Autowired
	private StationRepository stationRepository;
	
	@Test
	public void test() {
		long id = 1l;
//		Station target = stationRepository.findById(id).orElseThrow(()-> new TargetNotfoundException());
		Station target = stationRepository.findById(id).orElseThrow(TargetNotfoundException::new);
		System.out.println(target);
	}

}

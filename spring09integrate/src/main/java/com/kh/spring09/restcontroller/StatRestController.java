package com.kh.spring09.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.StatDao;
import com.kh.spring09.vo.StatVO;

@CrossOrigin
@RestController
@RequestMapping("/rest/stat")
public class StatRestController {

	@Autowired
	private StatDao statDao;
	
	@PostMapping("/country-region")
	public Map<String, Object> countryByRegion(){
		List<StatVO> list = statDao.countryByRegion();
		
		
		
		//return list;//프론트엔드에서 쓰기 어려운 형태
		
		List<String> titles = new ArrayList<>();//제목만 들어갈 리스트
		List<Double> values = new ArrayList<>();//값만 들어갈 리스트

		for(StatVO statVO : list) {
			titles.add(statVO.getTitle());//제목을 추가
			values.add(statVO.getValue());//값을 추가 
		}
		
		//두개를 묶으려면 class를 만들거나 Map으로 하거나 
		//Map 는 나중에 알아보기 힘듬. 결국 class로
		return Map.of("titles", titles, "values", values);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

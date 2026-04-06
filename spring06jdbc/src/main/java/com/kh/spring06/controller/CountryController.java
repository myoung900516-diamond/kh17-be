package com.kh.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.CountryDao;
import com.kh.spring06.dto.CountryDto;

@RestController//등록(제어 반전, IoC, Inversion of Control)
public class CountryController {
	@Autowired//주세요!(의존성 주입,  DI, Dependency Injection)
//	private JdbcTemplate jdbcTemplate;
	private CountryDao countryDao;

	//country 등록을 위한 페이지 
	@RequestMapping("/insert")
	public String insert(@ModelAttribute CountryDto countryDto) {
		countryDao.insert(countryDto);
		return "국가 정보 등록이 완료되었습니다";
	}
}

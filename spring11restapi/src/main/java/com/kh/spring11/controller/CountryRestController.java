package com.kh.spring11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.dao.CountryDao;
import com.kh.spring11.dto.CountryDto;

@CrossOrigin
@RestController
@RequestMapping("/api/country")
public class CountryRestController {

	@Autowired
	private CountryDao countryDao;
	//등록
	@PostMapping("/")
	public CountryDto insert(@RequestBody CountryDto countryDto) {
		int countryNo = countryDao.sequence();
		countryDto.setCountryNo(countryNo);
		countryDao.insert(countryDto);
		return countryDto;
		
	}
}

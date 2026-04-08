package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.CountryDao;

@Controller
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private CountryDao countryDao;
	
	//등록(화면과 처리 코드 결합)
	//-예상되는 흐름: [입력] -> [처리+출력}
//	@RequestMapping("/country/insert1")
//	@RequestMapping("/country/insert2")
	
	@RequestMapping("/insert1")
	public String insert1() {
		return "/WEB-INF/views/country/insert1.jsp";
	}
	@RequestMapping("/insert2")
	public String insert2() {
		return "/WEB-INF/views/country/insert2.jsp";
	}


}

package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.CountryDao;
import com.kh.spring09.dto.CountryDto;

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
	public String insert2(@ModelAttribute CountryDto countryDto) {
		countryDao.insert(countryDto);
//		return "/WEB-INF/views/country/insert2.jsp";
//		return "redirect:/country/insert3";//절대경로
		return "redirect:./insert3";//상대경로
	}
	@RequestMapping("/insert3")
	public String insert3() {
		return "/WEB-INF/views/country/insert3.jsp";
	}


}

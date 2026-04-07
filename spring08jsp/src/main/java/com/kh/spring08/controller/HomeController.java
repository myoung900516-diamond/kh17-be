package com.kh.spring08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//새로운 등록(화면을 줄게!)
@RequestMapping("/home ")
public class HomeController {
	@RequestMapping("/welcome")
	public String welcome() {
//		return "jsp는 어디에 숨어있을까";
		//webapp 뒤의 경로를 슬래시부터 작성(슬.래.시.부.터)
		return "/WEB-INF/views/welcome.jsp";
	}
}

package com.kh.spring08.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jsp")
public class JspController {
	//화면에 전달해야할 데이터가 있다면 모델(Model)을 매개변수에 선언하고 데이터 추가
	
	@RequestMapping("/test01")
	public String test01(Model model) {
		//model에 원하는 데이터를 "이름을 붙여서" 전달(String, Object)
		//model.addAttribute("이름", 값)'
		model.addAttribute("message", "Hello MVC Pattern!");
		Random r = new Random();
		int dice = r.nextInt(6) + 1;
		model.addAttribute("dice", dice);
		int lotto = r.nextInt(45) + 1;
		model.addAttribute("lotto", lotto);
		return "/WEB-INF/views/jsp/test01.jsp";
	}
	
//	@GetMapping("/test021")
//	public String test021() {
//		return "/WEB-INF/views/jsp/test02.jsp";
//	}
//	
//	@PostMapping("/test02")
//	public String test02(Model model, @RequestParam String q) {
//		Format f = new SimpleDateFormat("yyyy");
//		String y =f.format(q);
//		int year = Integer.parseInt(y);
//		int age = LocalDate.now().getYear() - year +1;
//		model.addAttribute("age", age);
//		return "/WEB-INF/views/jsp/test03.jsp";
//	}
	@RequestMapping("/test02")
	public String test02(@RequestParam String birth, Model model) {
		LocalDate d = LocalDate.parse(birth);
		LocalDate cur = LocalDate.now();
		
		Period period = Period.between(d, cur);//기간을 구해라!
		int globalAge = period.getYears();//만나이
		
		int koreanAge = cur.getYear() - d.getYear() + 1;//한국나이
		
		model.addAttribute("globalAge", globalAge);//만나이를 모델에 추가
		model.addAttribute("koreanAge", koreanAge);//한국나이를 모델에 추가
		
		return "/WEB-INF/views/jsp/test02.jsp";//화면을 연동
	}
	
	@RequestMapping("/test03")
	public String test03(@RequestParam long krw, Model model) {
		double exchangeToUsd = 0.00067;
		double exchangeToCny = 0.00465;
		double exchangeToJpy = 0.106;
		
		model.addAttribute("usd", krw * exchangeToUsd);
		model.addAttribute("cny", krw * exchangeToCny);
		model.addAttribute("jpy", krw * exchangeToJpy);
		
		return "/WEB-INF/views/jsp/test03.jsp";
	}
	@RequestMapping("/test04")
	public String test04(Model model) {
		//배열이나 리스트와 같이 여러 개의 데이터가 묶여 있는 경우 이를 전달하여 출력
		Random r = new Random();
		Set<Integer> lotto = new TreeSet<>();
		while(lotto.size() < 6) {
			lotto.add(r.nextInt(45)+1);
		}
		model.addAttribute("lotto", lotto);//저장소 전달
		return "/WEB-INF/views/jsp/test04.jsp";
	}
	@RequestMapping("/test05")
	public String test05(Model model) {
		Random r = new Random();
		List<Integer> dice = new ArrayList<>();
		while(dice.size()<10) {
			dice.add(r.nextInt(6)+1);
		}
		model.addAttribute("dice", dice);
		return "/WEB-INF/views/jsp/test05.jsp";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

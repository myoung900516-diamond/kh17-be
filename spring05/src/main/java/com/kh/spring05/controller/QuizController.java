package com.kh.spring05.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {
	@RequestMapping("/")
	public String home() {
		return " welcome, bro.";
	}
	@RequestMapping("/quiz01")
	public String age(@RequestParam int y) {
		//int age = 2026 - y;
		int age = LocalDate.now().getYear() - y+1;
		return "age = " + age;
	}
	@RequestMapping("/quiz02")
	public String bmi(@RequestParam double h, double w) {
		double m = h/100;
		double bmi = w/(m*m);
		return "bmi = " + bmi;
	}
	@RequestMapping("/quiz03")
	public String period(@RequestParam String begin, String end) {
//		Format f = new SimpleDateFormat("yyyy-MM-dd");
//		long b = f.format(begin);
//		long e = f.format(end);
		
		LocalDate b = LocalDate.parse(begin);
		LocalDate e = LocalDate.parse(end);
		long period = ChronoUnit.DAYS.between(b, e);
		return "period = " + period;
	}
	@RequestMapping("/quiz04")
	public String result(@RequestParam double k, double e, double m) {
		double total = k + e + m;
		double average = total/3.0;
		return "total score = " + total +", " + "average score = " + average;
	}
	@RequestMapping("/quiz05")
	public String price(@RequestParam(defaultValue = "2006") int y) {
		int age = LocalDate.now().getYear() - y+1;
//		switch(age) {
//		case age>=65 || age<=8 return "free";
//		case age<=19 return "550";
//		case age<=15 return "550";
//		case age<65 return "1550";
		if(age <= 7  || age >= 65) {
			return "price = 0";
		}
		else if(age <= 13) {
			return "price = 550";
		}
		else if(age <= 19) {
			return "price = 900";
		}
		else {
			return "price = 1550";
		}
	}
}

























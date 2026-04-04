package com.kh.spring05.quizcontroller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class QuizContoller {
	@RequestMapping("/")
	public String home() {
		return " welcome, bro.";
	}
	@RequestMapping("/quiz01")
	public String age(@RequestParam int y) {
		//int age = 2026 - y;
		int age = LocalDate.now().getYear() - y;
		return "age = " + age;
	}
	@RequestMapping("/quiz02")
	public String bmi(@RequestParam double h, double w) {
		double bmi = w/(h*h) + w%(h*h);
		return "bmi = " + bmi;
	}
	//@RequestMapping("/quiz03")
	//public String period(@RequestParam String begin, String end) {
		
	//}
	
}

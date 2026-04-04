package com.kh.spring05.quizcontroller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
	
}

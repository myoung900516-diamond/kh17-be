package com.kh.spring02;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String kh() {
		return "KH정보교육원";
	}
	@RequestMapping("/dice")
	public int dice() {
		Random r = new Random();
		int d = r.nextInt(6) + 1;
		return d;
	}
	@RequestMapping("/lotto")
	public int lotto() {
		Random r = new Random();
		int l = r.nextInt(45) + 1;
		return l;
	}
}

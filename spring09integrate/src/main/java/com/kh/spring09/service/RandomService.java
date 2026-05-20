package com.kh.spring09.service;

import java.util.Random;

import org.springframework.stereotype.Service;


//랜덤 숫자, 랜덤 문자열 랜덤과 관련된 것만 처리한다. 
@Service
public class RandomService {
	
	private Random r = new Random();
	
	private String numbers = "0123456789";
	
	private String lowerCases = "abcdefghijklmnopqrstuvwxyz";
	
	private String upperCases = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	//숫자생성
	public String generateNumber(int size) {
		StringBuffer buffer = new StringBuffer();
		
		for(int i=0; i<size; i++) {
			int index = r.nextInt(numbers.length());
			char ch = numbers.charAt(index);
			buffer.append(ch);
		}
		
		return buffer.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

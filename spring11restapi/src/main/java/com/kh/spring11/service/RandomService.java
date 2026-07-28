package com.kh.spring11.service;

import java.util.Random;

import org.springframework.stereotype.Service;


//랜덤 숫자, 랜덤 문자열 랜덤과 관련된 것만 처리한다. 
@Service
public class RandomService {
	
	private Random r = new Random();
	
	private String numbers = "0123456789";
	
	private String lowerCases = "abcdefghijklmnopqrstuvwxyz";
	
	private String upperCases = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private String special = "!@#$%^&*()-_+=";
	
	//숫자생성
	public String generateNumber(int size) {
		StringBuffer buffer = new StringBuffer();
		
		for(int i=0; i<size; i++) {
			int index = r.nextInt(numbers.length());
			char ch = numbers.charAt(index);
			buffer.append(ch);
		}
//		System.out.println(buffer.toString());
		return buffer.toString();
	}
	
	public String generateString(int size) {
		StringBuffer buffer = new StringBuffer();
		
//		for(int i=0; i<size; i++) {
//			int index = r.nextInt(numbers.length());
//			char ch = numbers.charAt(index);
//			char ch2 = upperCases.charAt(index);
//			char ch3 = lowerCases.charAt(index);
//			char ch4 = special.charAt(index);
			
			//종류를 선택하는 코드
//			String target;
//					int type = r.nextInt(4);
//			switch(type) {
//			case 0 : target = numbers; break;
//			case 1 : target = lowerCases; break;
//			case 2 : target = upperCases; break;
//			case 3 : target = special; break;
//			default : target = special;
//			}
			
//			int type = r.nextInt(4);
//			String target=switch(type) {
//			case 0 : yield numbers;
//			case 1 : yield lowerCases; 
//			case 2 : yield upperCases; 
//			case 3 : yield special; 
//			default : yield special;
//			};
		for(int i = 0; i< size; i++) {
			
		
		//-Java 13+에서 사용 가능한 switch var 구문
			int type = r.nextInt(4);
			String target=switch(type) {
			case 0  -> numbers;
			case 1  -> lowerCases; 
			case 2  -> upperCases; 
			case 3 -> special; 
			default -> special;
			};
			
			//종류에 따른 글자 선택
			int position = r.nextInt(target.length());
			
			//추가
			
			buffer.append(target.charAt(position));
		}
		
//		System.out.println(buffer.toString());
		return buffer.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

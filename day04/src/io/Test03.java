package io;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("출생연도를 입력하세요.");
		int number = sc.nextInt();
		//System.out.println( number + "년도");
		
		System.out.println("출생월을 입력하세요.");
		int number2 = sc.nextInt();
		//System.out.println(number2 + "월 입니다.");
		//시간 계산은 주어진 값 중 가장 작은 걸로 합쳐서 계산
		//연도, 월 ---> 월
		//시간, 분 ---> 분
		//입력을 꼭 먼저 할 필요는 없어요. 
		int year = 2026;
		int old = year - number;
		int month = old*12;
		int month2 = 
		
		System.out.println("만 나이는" + old + "(" + month + "개월) 입니다.");
		*/
		
		//입력
		int year = 2025;
		int month = 3;
		
		
		//처리
		int currentYear = 2026;
		int currentMonth = 3;
		
		int total = year * 12 + month;
		int current = currentYear * 12 + currentMonth;
		int diff = current - total; //개월 수
		
		int globalAge = diff / 12;
		
		//출력
		System.out.println("만나이 : " + globalAge + "세");
		
	}
	
	

}

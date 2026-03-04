package io;

import java.util.Scanner;

public class Test04성적분석기 {
	public static void main(String[] args) {
		
		//입력
		//int a = 84;
		//int b = 93;
		//int c = 38;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 과목 점수를 입력하세요.");
		int a = sc.nextInt();
		System.out.println("두번째 과목 점수를 입력하세요.");
		int b = sc.nextInt();
		System.out.println("세번째 과목 점수를 입력하세요.");
		int c = sc.nextInt();

		
		//처리
		int total = a + b + c;
		double average = (double)total/3.0;
		System.out.println("평균점수 : " + average);
		boolean pass = a>= 40 && b>= 40 && c>= 40 && average>=60;
		
		//출력
		
		System.out.println("결과 : " + pass);
		
	}

}

package io;

import java.util.Scanner;

public class Test04성적분석기3 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("1과목 점수 : ");
		int score1 = sc.nextInt();
		System.out.print("2과목 점수");
		int score2 = sc.nextInt();
		System.out.print("3과목 점수");
		int score3 = sc.nextInt();
		
		

		
		//처리
		int total = score1 + score2 + score3;
		float average = (float)total/3;
		boolean pass = score1>= 40 && score2>= 40 && score3>= 40 && average>=60;
		
		//출력
		System.out.println("평균점수 : " + average + "점");		
		System.out.println("결과 : " + pass);
		
	}

}

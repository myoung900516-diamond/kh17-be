package array;

import java.util.Scanner;

public class Test03점수분석기3 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		//int score = sc.nextInt();
		System.out.println("다섯명 점수를 순서대로 입력");
		int[] scoreList = new int[] { sc.nextInt(),  sc.nextInt(),  sc.nextInt(),  sc.nextInt(),  sc.nextInt()};
		
		for(int i = 0; i< scoreList.length;i++) {
			
		
		System.out.println("개별점수 : " + scoreList[i]);
		}
//		System.out.println("개별점수 : " + b);
//		System.out.println("개별점수 : " + c);
//		System.out.println("개별점수 : " + d);
//		System.out.println("개별점수 : " + e);
//		
		int great = 0;
		for(int i = 0; i < scoreList.length; i++) {
		if(scoreList[i] >= 90)great++;
		}
//		if(a>= 90) great ++;
//		if(b>= 90) great ++;
//		if(c>= 90) great ++;
//		if(d>= 90) great ++;
//		if(e>= 90) great ++;
		System.out.println("90점 이상 인원수 = " + great);
//		
		int bad = 0;
		for(int i = 0; i < scoreList.length; i++) {
			if(scoreList[i]<60 ) {
				bad++;
				
			}
		}
		System.out.println("60점 미만 인원수 = " + bad);
//		if(a < 60) bad++;
//		if(b < 60) bad++;
//		if(c < 60) bad++;
//		if(d < 60) bad++;
//		if(e < 60) bad++;
//		System.out.println("60점 미만 인원수 = " + bad);
//		
		int total = 0;
		for(int i = 0; i < scoreList.length; i++) {
			total += scoreList[i];
		}
		double average = total / scoreList.length;
		System.out.println("평균점수는 : " + average);
//		int total = a + b + c + d + e;
//		
//		double average = total/5;
//		System.out.println("평균 점수는 : " + average);
		
		
		
	}

}

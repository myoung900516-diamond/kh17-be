package array;

import java.util.Scanner;

public class Test03점수분석기2 {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("학생의 점수를 입력하세요.");
//		int score = sc.nextInt();
//		
		//int a = 85, 95, 65, 93, 99;
		int[] score = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
		int countGood = 0;
		int countBad =0;
		int total =0;
		for(int i = 0; i < score.length ; i++) {
			System.out.println("개별점수 : " + score[i] + "점");
		}
		for(int i = 0; i<score.length; i ++) {
		if(score[i] >= 90) 
			countGood ++;
			}
		System.out.println("90점 이상인 사람 수 : " + countGood + "명");
		for(int i = 0; i <score.length; i++) {
			if(score[i] < 60) countBad ++;{
			}
		}
		System.out.println("60점 미만인 사람 수: " + countBad + "명");

		for(int i = 0; i < score.length; i++) {
			total = total + score[i];
		}
		double average = total / score.length;
		System.out.println("평균점수는 " + average + "점");
		}
		
	}



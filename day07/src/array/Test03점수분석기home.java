package array;

import java.util.Scanner;

public class Test03점수분석기home {
	public static void main(String[] args) {
		
		int[] scoreList = new int[5]; //{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};

		Scanner sc = new Scanner(System.in);
		int count = 0;
		for(int i = 0; i < scoreList.length; i++) {
			count ++;
			System.out.print(count + "번의 점수 : ");
		           scoreList[i] = sc.nextInt();}
		
		
		
		//int score = sc.nextInt();
		
		//int a = 80, b = 90, c = 99, d = 100, e = 55;
		
		int good = 0;
		int bad = 0;
		int total = 0;
		
		for(int i = 0; i <scoreList.length; i++) {
			System.out.println("개별 점수 : " + scoreList[i] + "점");
		}
		for(int i = 0; i < scoreList.length; i++) {
			if(scoreList[i] >= 90) {
				good ++;
			}
		}
		System.out.println("90점 이상 학생 수 : " + good + "명");
		
		for(int i = 0; i < scoreList.length; i++) {
			if(scoreList[i] <60) {
				bad++;
			}
		}
		System.out.println("60점 미만 학생수 : " + bad + "명");
		
		for(int i = 0; i < scoreList.length; i++) {
			total = total + scoreList[i];
		}
		double average = total / scoreList.length;
		System.out.println("평균 점수 : " + average + "점");
		
	}

}

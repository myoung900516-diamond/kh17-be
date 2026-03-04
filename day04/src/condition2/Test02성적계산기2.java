package condition2;

import java.util.Scanner;

public class Test02성적계산기2 {
	public static void main(String[] args) {
		
		//입력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 점수를 입력하세요.");
		int kor = sc.nextInt();
		System.out.println("영어 점수를 입력하세요.");
		int eng = sc.nextInt();
		System.out.println("수학 점수를 입력하세요.");
		int math = sc.nextInt();
		
		
		//처리
		int total = kor + eng + math;
		double average = (double)total/3;
		//String grade = "A" or "B" or "C" or "D";
		String grade; //char 는 A+못써서 미래를 보고 string을 씀
		if(average >= 90) {
			grade = "A";
		}
		else if (average >= 80) {
			grade = "B";
		}
		else if(average >= 70) {
			grade = "C";
		}
		else {
			grade = "D";
		}
		
		//출력
		
		System.out.println("평균 : " + average + "점");
		System.out.println("등급 : " + grade);
		
		/*
		//출력 웬만하면 출력에서 조건을 쓰지마라. 
		System.out.println("평균 점수는 " + average + "점 입니다.");
		if (average >= 90) {
			System.out.println("등급은 A등급 입니다." );
		}
		
		else if (average >=80) {
			System.out.println("등급은 B등급 입니다.");
			
		}
		else if (average >= 70) {
			System.out.println("등급은  C등급 입니다.");
		}
		
		else {
			System.out.println("등급은 D등급입니다. ");
		}
	
		*/
		
	}

}

package condition3;

import java.util.Scanner;

public class Test03학점계산기3 {
	public static void main(String[] args) {
		 
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		int score = sc.nextInt();
		//int score = 55;
		
		//처리
		//(참고) 자바 신버전(17+)의 람다(lambda)프로그래밍
		int ten = score / 10;
		String grade = switch(ten) {
		case 9, 10 -> "A+";
		case 8 -> "A";
		case 7 -> "B";
		case 6 -> "C";
		default -> "F";
		};
			System.out.println("학점 : " + grade + "입니다.");
		
		
		
	}

}

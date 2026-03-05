package condition3;

import java.util.Scanner;

public class Test03학점계산기2 {
	public static void main(String[] args) {
		 
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		int score = sc.nextInt();
		//int score = 55;
		
		//처리
		int ten = score / 10;
		String grade;
		//출력
		switch(ten) {
		case 9: case 10:
			grade = "A+";
			break;
		case 8:
			grade = "A";
			break;
		case 7:
			grade = "B";
			break;
		case 6:
			grade = "C";
			break;
		default:
				grade = "F";
			break;
		}
			System.out.println("학점 : " + grade + "입니다.");
		
		
		
	}

}

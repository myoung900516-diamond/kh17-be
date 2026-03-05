package condition3;

import java.util.Scanner;

public class Test03학점계산기 {
	public static void main(String[] args) {
		 
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		int score = sc.nextInt();
		//int score = 55;
		
		//처리
		String level;
		
		if(score>=90 && score <= 100) {
			level = "A+";
		}
		else if(score>= 80) {
		     level = "A";
		}
		else if (score >=70) {
			level = "B";
		}
		else if (score >=60) {
		    level = "C";
		}
		else {
			level = "F";
		}
		//출력
		System.out.println("학점 : " + level + "입니다.");
		
		
		
	}

}

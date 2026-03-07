package loop3;

import java.util.Scanner;

public class Test05숫자모레성게임 {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("모레성 게임 START(100부터 시작)");
		
		int number = 100;
		while(true) {
			int user = sc.nextInt();
			/*
			if ( user > 9) {
				//break;
				System.out.println("잘못 입력하셨습니다.");
			}
			if (user == 1) {
				number -= 1;
				System.out.println(number);
			}
			if (user == 2) {
				number -= 2;
				System.out.println(number);
			}
			if (user == 3) {
				number -= 3;
				System.out.println(number);
			}
			if (user == 4) {
				number -= 4;
				System.out.println(number);
			}
			if (user == 5) {
				number -= 5;
				System.out.println(number);
			}
			if (user == 6) {
				number -= 6;
				System.out.println(number);
			}
			if (user == 7) {
				number -= 7;
				System.out.println(number);
			}
			if (user == 8) {
				number -= 8;
				System.out.println(number);
			}
			if (user == 9) {
				number -= 9;
				System.out.println(number);
			}
			if(number <0) {
				break;
			}
			*/
			if (user > 9) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			
			if( user <1 ) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			
//			for ( int i = user ; i <= 9 ; i ++) {
//				number -= user;
//				System.out.println(number);
//				System.out.println(user + "만큼 줄어듭니다.");
//				
//			}
			number -=user;
			System.out.println(number);
			System.out.println(user + "만큼 줄어듭니다.");
			
			
			if (number <= 0) 
				break;
		}
		System.out.println("game over");
	}

}
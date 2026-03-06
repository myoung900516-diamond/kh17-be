package loop3;

import java.util.Scanner;

public class Test02홀수짝수설명 {
	public static void main(String[] args) {
		
		
		//1회의 입력을 통해 홀수 짝수 구분
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("숫자입력(0입력시 종료)");
		int number = sc.nextInt();
		
		if(number % 2 == 0) {
			System.out.println("짝수");
		}
		else {
			System.out.println("홀수");
			
		}
	}

}

package loop3;

import java.util.Scanner;

public class Test02홀수짝수설명3 {
	public static void main(String[] args) {
		
		
		//1회의 입력을 통해 홀수 짝수 구분
		Scanner sc = new Scanner(System.in);
		
		int odd = 0;
		int even = 0;
			
		while(true) {
			System.out.println("숫자입력(0입력시 종료)");
			int number = sc.nextInt();
			//위치가 중요함
			//종료조건
			
			if(number == 0) break;
			if(number % 2 == 0) {
				//System.out.println("짝수");
				even++;
			}
			else {
				//System.out.println("홀수");
				odd++;
				
			}
			System.out.println("홀수 = " + odd + "개");
			System.out.println("짝수 = " + even + "개");
		}
		
	}

}

package loop3;

import java.util.Random;
import java.util.Scanner;

public class Test03업다운게임home {
	
	
	public static void main(String[] args) {
		Random r = new Random();
		
		int number = r.nextInt(1000) + 1;
		//System.out.println(number);
		System.out.println("1~1000 사이의 숫자를 맞추세요");
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		
		while(true) {
			int user = sc.nextInt();
			count ++;
			
			if( user > number) {
				System.out.println("다운");
			}
			else if ( user < number) {
				System.out.println("업");
			}
			else {
				System.out.println("정답");
				break;
			}
		}
		System.out.println("시도한 횟수 : " + count + "회");
	}
}

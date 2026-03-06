package loop3;

import java.util.Random;
import java.util.Scanner;

public class Test03업다운게임 {
	public static void main(String[] args) {
		
		Random r = new Random();
		int number = r.nextInt(1000) + 1;
		//int number = 500;
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		
		while(true) {
		System.out.println("업 & 다운 문제 : 1에서 1000사이의 숫자를 입력하세요.");
		
		int user = sc.nextInt();
		count ++;
		
		if(user < number) {
			System.out.println("업");
			
		}
		else if(user > number) {
			System.out.println("다운");
		}
		else {
			System.out.println("정답");
			
			break;
		}
		}
		System.out.println("시도한 횟수 : " + count + "회");
	}

}

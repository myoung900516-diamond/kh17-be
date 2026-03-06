package loop3;

import java.util.Random;
import java.util.Scanner;

public class Test03업다운게임2 {
	public static void main(String[] args) {
		//1회의 업다운 게임을 구현해보자 
		//-정답 생성(1부터 1000까지 = 1부터 1000개)
		Random r = new Random();
		int answer = r.nextInt(1000) + 1;
		System.out.println("answer = " + answer);
		
		//-사용자입력
		Scanner sc = new Scanner(System.in);
		System.out.print("정답입력 : ");
		int user = sc.nextInt();
		
		if(answer > user) { 
			System.out.println("업");
		}
		else if(answer < user) { 
			System.out.println("다운");
		}
		else {
			System.out.println("정답");
		}
		
		
		
	}

}

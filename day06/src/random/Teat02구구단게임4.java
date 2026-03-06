package random;

import java.util.Random;
import java.util.Scanner;

public class Teat02구구단게임4 {
	public static void main(String[] args) {
		
		//무작위 구구단 문제 1개를 출제
		//-범위 : 2 x 1 부터 9 x 9까지 
		//-좌측 단은 2~9의 범위를 가짐 ( = 2부터 8개)
		//-우측 수는 1~9의 범위를 가짐 (=1부터 9개)
	    //정답 판정
		Random r = new Random();
		int left = r.nextInt(8) + 2;
		int right = r.nextInt(9) + 1;
		System.out.println(left + " x " + right + " = ");
		//뻘짓 다 해봐라. 시도를 다 해봐라. 
		
		Scanner sc = new Scanner(System.in);
		int user = sc.nextInt();
		
		//boolean correct = left * right == user;
		if(left * right == user) {//정답이라면
			System.out.println("정답");
		}
		else {
			System.out.println("오답");
		}
		
	}
	
	
}

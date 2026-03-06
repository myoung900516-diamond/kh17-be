package random;

import java.util.Random;

public class Teat02구구단게임3 {
	public static void main(String[] args) {
		
		//타자연습 계속 하세요. 
		
		//무작위 구구단 문제 1개를 출제
		//-범위 : 2 x 1 부터 9 x 9까지 
		//-좌측 단은 2~9의 범위를 가짐 ( = 2부터 8개)
		//-우측 수는 1~9의 범위를 가짐 (=1부터 9개)
		for(int i = 1; i <= 10 ; i ++) {
		Random r = new Random();
		int left = r.nextInt(8) + 2;
		int right = r.nextInt(9) + 1;
		System.out.println(left + " x " + right + " = ");
		//뻘짓 다 해봐라. 시도를 다 해봐라. 
		}
	}
	
	
}

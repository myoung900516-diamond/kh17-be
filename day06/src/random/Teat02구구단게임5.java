package random;

import java.util.Random;
import java.util.Scanner;

public class Teat02구구단게임5 {
	public static void main(String[] args) {
		

		//10회로 변경 
				//주의! 도구(random, scanner, ...)는 반복문 바간으로 빼야합니다. 왜냐하면 낭비가 심하니까. 
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
	
		
		
		for(int i = 1; i <=10 ; i ++) {
		
		int left = r.nextInt(8) + 2;
		int right = r.nextInt(9) + 1;
		System.out.println(left + " x " + right + " = ");
		//뻘짓 다 해봐라. 시도를 다 해봐라. 
		
		
		int user = sc.nextInt();
		
		//boolean correct = left * right == user;
		if(left * right == user) {//정답이라면
			//System.out.println("정답");
		}
		else {
			//System.out.println("오답");
		}
		}
	}
	
	
}

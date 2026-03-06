package random;

import java.util.Random;
import java.util.Scanner;

public class Teat02구구단게임6 {
	public static void main(String[] args) {
		//카운트 추가
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int correct = 0, incorrect = 0;
		
		
		for(int i = 1; i <=10 ; i ++) {
		
		int left = r.nextInt(8) + 2;
		int right = r.nextInt(9) + 1;
		System.out.println(left + " x " + right + " = ");
		//뻘짓 다 해봐라. 시도를 다 해봐라. 
		
		
		int user = sc.nextInt();
		
		//boolean correct = left * right == user;
		if(left * right == user) {//정답이라면
			//System.out.println("정답");
			correct++;
		}
		else {
			//System.out.println("오답");
			incorrect++;
			
			
		}
		}
		System.out.println("<게임 결과>");
		System.out.println("정답 개수 : " + correct + "개");
		System.out.println("오답 개수 : " + incorrect + "개");
	}
	
	
}

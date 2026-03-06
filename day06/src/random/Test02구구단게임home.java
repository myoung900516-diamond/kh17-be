package random;

import java.util.Random;
import java.util.Scanner;

public class Test02구구단게임home {
	public static void main(String[] args) {
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
	
		
		int round = 1;
		int count = 1;
		int score = 10;
		int combo = 0;
		int total = 0;
		
		for(int i = 1; i <= 10*round; i++) {
			
			int guguLeft = r.nextInt(8) + 2;
			int guguRight = r.nextInt(9) + 1;
			System.out.println(i + "." + guguLeft + " x " + guguRight + " = ");

			int answer = sc.nextInt();
		
		
		if(answer == guguLeft * guguRight) {
			//score +=10;
			combo ++;
		 
            System.out.println(score*combo + "점  (" + combo + "콤보)");
            total += score*combo;
            System.out.println("누적 점수는 " + total + "점");

		}
		else {
		
			count ++;
			combo = 0;
		System.out.println("오답");
		if(count >3) {
			break;
		}
		
		}
		}
	}

}

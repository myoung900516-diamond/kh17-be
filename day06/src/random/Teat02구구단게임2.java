package random;

import java.util.Random;
import java.util.Scanner;

public class Teat02구구단게임2 {
	public static void main(String[] args) {
		int countO = 0;
		int countX = 0;
		int round = 1;
		int score = 0;
		int score1 = 0;
		
		for(int question = 1 ; question<= 10*round; question ++) {

		Random r = new Random();
		int gugudan = r.nextInt(9) + 1;
		int gugudan2 = r.nextInt(9) + 1;
		System.out.println(question + "." + gugudan + "*" + gugudan2 +" 의 정답을 맞혀보세요");
		
		Scanner sc = new Scanner(System.in);
		int answer = sc.nextInt();
		int good = gugudan * gugudan2;
		if( answer == good) {
			//System.out.println("정답입니다.");
			countO ++;
			score = 10*countO*(countO + 1)/2;
			
//			boolean a = answer != good;
//			if (a) {
//				break;
//			}
			
//			if(answer != good) {
//				score1 = 10*countO;
//				System.out.println("점수는 : " + score1 + "점 입니다.");
//				
//			}
			System.out.println("점수는 : " + score + "점 입니다.");
			
			
		}
		else {
			//System.out.println("오답입니다.");
			countX ++;
			
			if( countX >= 3) {
				break;
			}
		}
	}
		//int score = countO * 10;
		
	System.out.println("정답은 " + countO + "개, 오답은 " + countX + "개 입니다." );
	System.out.println("점수는 : " + score + "점 입니다.");
	
	}
}

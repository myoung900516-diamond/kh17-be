package random;

import java.util.Random;
import java.util.Scanner;

public class Teat02구구단게임9 {
	public static void main(String[] args) {
		
		//콤보
		//-콤보는 0으로 초기화 될 수 있는 카운트
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		
		int round = 1;
		int size = round * 10;
		int life = 3; //남은 기회
		int combo = 0;//콤보 카운트 
		
		System.out.println("라운드 : " + round + "(" + size + "문항)");
		for(int i = 1; i <=size ; i ++) {
		
		int left = r.nextInt(8) + 2;
		int right = r.nextInt(9) + 1;
		System.out.println(left + " x " + right + " = ");
		//뻘짓 다 해봐라. 시도를 다 해봐라. 
		
		
		int user = sc.nextInt();
		
		//boolean correct = left * right == user;
		if(left * right == user) {//정답이라면
			//System.out.println("정답");
			combo++;
			if(combo >= 2) {
				System.out.println(combo + "콤보");
			}
			
		}
		else {
			//System.out.println("오답");
			combo = 0;
		life--;
		if(life ==0) {//기회가 없으면(0이면)
			break; //나가세요~ 
		}
			
			
		}
		}
		if(life >0) {
			System.out.println("클리어");
		}
		else {
			System.out.println("게임오버");
			
		}
	
	}
	
	
}

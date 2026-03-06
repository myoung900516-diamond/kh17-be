package loop3;

import java.util.Random;

public class Test01무한반복2 {
	public static void main(String[] args) {
		//무한반복 = 영원히 끝나지 않는 반복?
		//무한이라는 건 영원히 끝나지 않는 게 아니라 특정 시점까지 실행되는 반복
		//= 횟수나 범위를 모름
		//= (ex) 주사위 두 개를 같은 값이 나올 때까지 던지세요
		
		
		Random r = new Random();
		
		while(true) {
		int dice = r.nextInt(6) + 1;
		int dice2 = r.nextInt(6) + 1;
		
		System.out.println("주사위 = " + dice + " , " + dice2 );
		
		if(dice == dice2) {
			break;
		}
		}
	}

}

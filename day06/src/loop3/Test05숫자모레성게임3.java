package loop3;

import java.util.Scanner;

public class Test05숫자모레성게임3 {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("모레성 게임 START(100부터 시작)");
		
		int number = 100;
		System.out.println("참가 인원수를 입력하세요");
		
		int player = sc.nextInt();
		
		int count = 1;
		
		while(true) {
			
			System.out.println("참가자" + count + "님의 숫자 :  ");
			int user = sc.nextInt();
		
			
			if (user != 1 || user != 2 || user !=3 || user !=4 || user !=5 ||user !=6 ||user !=7 || user !=8 || user !=9) {
				
				//while(true) {
					System.out.println("잘못 입력하셨습니다.");
//					count++;
//					if(count > player) {
//						count = 1;
//					}
					count = count%player +1;
				//if(count> player)break;
					//System.out.println("참가자" + count +"님의 숫자 : ");
				//}
				continue;
			}
			number -=user; 
			System.out.println("현재 모래 : " + number);

			if (number <= 0) {
				System.out.println("참가자" +count + "님의 패배");
			break;
			}
			
			//System.out.println(number);
			//System.out.println(user + "만큼 줄어듭니다.");
			
				count = count%player +1;
			
		}
		//System.out.println("참가자" +() + "님의 패배");
		//System.out.println("game over");
	}

}

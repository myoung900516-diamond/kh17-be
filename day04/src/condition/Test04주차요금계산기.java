package condition;

import java.util.Scanner;

public class Test04주차요금계산기 {
	public static void main(String[] args) {
		
		//입력
		int pricePer10 = 500;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("들어온시각을 알려주세요.");
		int h1 = sc.nextInt();
		System.out.println("나간시각을 알려주세요.");
		int h2 = sc.nextInt();
		
		
		//처리
		int minute1 = h1 /100 * 60 + h1 % 100;
		int minute2 = h2 /100 * 60 + h2 % 100;
		int use = minute2 - minute1;
		
		int hour = use / 60;
		int minute = use % 60;
		
		boolean free = use < 30; 
		
		//출력 입출력은 단순하게, 계산은 복잡하게
		if(free == false) {
			int price = use/10 * pricePer10;
			System.out.println("이용시간은 " + hour + "시간 " + minute + "분 입니다.");
			System.out.println("이용요금은 " + price + "원 입니다.");
			
		}
		
		else {
			System.out.println("회차시간입니다.");
			
		}
		
	}

}

package condition2;

import java.util.Scanner;

public class Test04여행사프로모션2 {
	public static void main(String[] args) {
		
		//입력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("인원수를 입력하세요");
		int person = sc.nextInt();
		//int person = 5;
		System.out.println("여행할 달을 입력하세요");
		int season = sc.nextInt();
		//int season = 11;
		System.out.println("여행 기간을 입력하세요.");
		int day = sc.nextInt();
		//int day = 15;
		
		
		int pricePerDay = 100000;
		
		
		int sprdiscount = 10;
		int somdiscount = 5;
		int hardiscount = 30;
		int windiscount = 25;



		
		//처리
		int price = person * day * pricePerDay;
		
		int total;
		if(season >= 3 && season<=5) {
			total = price * (100 - sprdiscount)/100;
		}
		else if(season>= 6 && season <= 8) {
			total = price * (100 - somdiscount)/100;
		}
		else if(season>=9 && season <= 11) {
			total = price * (100 - hardiscount)/100;
		}
		else {
			total = price * (100 - windiscount)/100;
		}
		int discount = price - total;

		
		//출력
		System.out.println("인원수 : " + person + "명");
		System.out.println("여행할 달 : " + season + "월");
		System.out.println("여행기간 : " + day + "일 ");
		System.out.println("할인받은 금액 : " + discount + "원");
		System.out.println("총 여행경비     : " + total + "원");
	
	}

}

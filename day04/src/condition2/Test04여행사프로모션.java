package condition2;

import java.util.Scanner;

public class Test04여행사프로모션 {
	public static void main(String[] args) {
		
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("헐! 대박! 진짜?");
		System.out.println("어디든 무조건 1박에 10만원!");
		System.out.println("직접 확인해보세요!");
		
		System.out.print("인원수 : ");
		int people = sc.nextInt();
				//2;
		System.out.print("달 : ");
		int month = sc.nextInt();
				//10;
		System.out.print("기간(일) : ");
		int days = sc.nextInt();
				//2;
		
		//처리
		//-할인 전 요금 : 1인당 1일 10만원
		int base = people * days * 100000;
		//double rate = 0.1 or 0.05 or 0.3 or 0.25;
		//int discount = (int)base * rate);
		int rate;
		//= 10 or 5 or 30 or 25;
		String season;
		if(month == 3 || month == 4 || month == 5)            //봄이라면)
				{
			rate = 10;
			season = "봄";
		}
		else if(month == 6 || month == 7 || month == 8)//여름이라면)
				{
			rate = 5;
			season = "여름";
		}
		else if( month == 9 || month == 10 || month == 11)//가을이라면)
				{
			rate = 30;
			season = "가을";
		}
		else{//겨을이라면)
			rate = 25;
			season = "겨울";
		}
		int discount = base * rate / 100;
		int price = base - discount;
		
		//출력
		System.out.println("<예상 금액>");
		System.out.println("인원수 : " + people + "명");
		System.out.println("여행가는 달 : " + month + "월");
		System.out.println("여행기간 : " + days + "일" );
		System.out.println("-------------------");
		System.out.println("예상 경비 : " + base + "원");
		System.out.println("계절(" + season + ")에 따른 할인  : " + rate +"%");
		System.out.println("할인금액  : " + discount + "원");
		System.out.println("-------------------");
		System.out.println("최종 결제 예상 금액 :  "+price + "원");
		
		/*
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
	*/
	}

}

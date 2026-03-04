package condition2;

import java.time.Year;
import java.util.Scanner;

public class Test03지하철요금계산기2 {
	public static void main(String[] args) {
		
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("출생년도 4자리 입력 : ");
		int birth = sc.nextInt();
		//int birth = 2000;
		int card = 500;
		
		
		//처리
		//-나이계산
		//int age = 2026 - birth + 1;
		int age = Year.now().getValue() - birth + 1;
		//int base = 0 or 550 or 900 or 1550;
		int base;
		
		if (age <= 7 || age >= 65) {
			base = 0;
		}
		else if(age <= 13) {
			base = 550;
		}
		else if(age <=19) {
			base = 900;
		}
		else {
			base = 1550;
		}
		int price = base + card;//최종 요금
		
		
		//출력
		System.out.println("당신의 나이 : " + age + "세");
		System.out.println("기본요금 : " + base + "원");
		System.out.println("카드보증금 : " + card + "원");
		System.out.println("결제요금 : " + price + "원");
		
	}
	

}

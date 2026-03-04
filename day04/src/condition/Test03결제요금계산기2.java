package condition;

import java.util.Scanner;

public class Test03결제요금계산기2 {
	public static void main(String[] args) {
		//입력
		int price = 48000;
		Scanner sc = new Scanner(System.in);
		System.out.print("인원수 : ");
		int people = sc.nextInt();
		
		//처리
		boolean event = people >= 4;
		
		//int discount = 15 or 0;//할인율
		int discount;//범위때문에 이곳에 생성만 해두고
		if(event) {
			discount = 15;//조건에 따라 값을 대입
		}
		else {
			discount = 0;//조건에 따라 값을 대입
		}
		int cash = price * people * (100-discount) / 100;
		
		//출력
		System.out.println("가격 : " + cash + "원");
	}
}



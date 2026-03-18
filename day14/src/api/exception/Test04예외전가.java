package api.exception;

import java.util.Scanner;

public class Test04예외전가 {
	public static void main(String[] args) {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("금액 : ");
		int money = sc.nextInt();
		System.out.println("인원 : ");
		int people = sc.nextInt();
		
		int price = Calculator.oneOverN(money, people); //원래 money / people
		int remain = Calculator.remainingAmount(money, people); //원래 money % people
		
		System.out.println("한 명당 " + price + "원 씩 이체하시면 됩니다.");
		System.out.println("자투리금액 : " + remain + "원");
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
	}

}

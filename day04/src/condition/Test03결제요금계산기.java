package condition;

import java.util.Scanner;

public class Test03결제요금계산기 {
	
	public static void main(String[] args) {
		
		//입력
		int pricePerPerson = 45000;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("인원수가 몇 명입니까?");
		int person = sc.nextInt();
		System.out.println("인원수는 " + person + "명 입니다.");
		
		
		
		//처리
		int price = pricePerPerson * person;
		
		double discount = (double)price * 0.85; //권장하지 않음. 
		
		//문제에 주어진 값이 코딩에 들어가야함
		
		
		
		//출력
		
		if(person >=4 ==true) {
			System.out.println("결제하실 금액은" + discount + "원 입니다.");

		}
		else {
			System.out.println("결제하실 금액은" + price + "원 입니다.");
		}
	}

}

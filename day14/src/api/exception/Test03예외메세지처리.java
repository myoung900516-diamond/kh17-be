package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03예외메세지처리 {
	public static void main(String[] args) {
		//(ex)N분의1계산기
		
		//예외 메세지를 커스터마이징하기
		
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("금액 : ");
		int money = sc.nextInt();
		if(money <=0) {
			throw new Exception("금액을 잘못 입력하셨습니다");
		}
		System.out.println("인원 : ");
		int people = sc.nextInt();
		if(people <0) {
			
			throw new Exception("인원을 잘못 입력하셨습니다");
		}
		
		int price = money / people;
		int remain = money % people;
		
		System.out.println("한 명당 " + price + "원 씩 이체하시면 됩니다.");
		System.out.println("자투리금액 : " + remain + "원");
		}
		catch(Exception e){//플랜B
			//System.err.println(e);//예외 정보가 담긴 객체
			//1. 사용자에게 뭘 보여줄 것인가?			
//			if(e.getMessage() == null) {
//			System.out.println("알 수 없는 오류가 발생했습니다");
//		}
//			System.err.println("오류 : " + e.getMessage());
			//2. 개발자는 뭘 확인할 수 있게 할 것인가? 
			e.printStackTrace();
		}
		 
	}

}

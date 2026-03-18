package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01예외처리가필요한이유4 {
	public static void main(String[] args) {
		//(ex)N분의1계산기
		
		//자바가 이해하지 못하는 예외(ex 금액이 0이하)를 강제로 예외로 처리
		
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("금액 : ");
		int money = sc.nextInt();
		if(money <=0) {
			//catch로 가쟈
			//throw new InputMismatchException();
			throw new Exception();
		}
		System.out.println("인원 : ");
		int people = sc.nextInt();
		if(money <=0) {
			//catch로 가쟈
			
			//throw new InputMismatchException();
			throw new Exception();
		}
		
		int price = money / people;
		int remain = money % people;
		
		System.out.println("한 명당 " + price + "원 씩 이체하시면 됩니다.");
		System.out.println("자투리금액 : " + remain + "원");
		}
		//catch(Object e){
		//catch(Throwable e){ //최상위 에러
		catch(Exception e){//최상위 예외, 통합 예외 처리 클래스 
		//catch(RuntimeException e){
			System.err.println("입력이 잘못되었습니다");
		}
		 
		
		
		
	}

}

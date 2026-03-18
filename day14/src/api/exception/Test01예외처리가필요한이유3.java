package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01예외처리가필요한이유3 {
	public static void main(String[] args) {
		//(ex)N분의1계산기
		
		//상속관계를 이용하여 통합 catch블록 생성
		
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("금액 : ");
		int money = sc.nextInt();
		System.out.println("인원 : ");
		int people = sc.nextInt();
		
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

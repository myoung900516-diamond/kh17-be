package api.util.etc;

import java.util.Scanner;

public class Test04스캐너와예외처리 {
	public static void main(String[] args) {
		//해결을 위한 시도
		//-try와 catch에 모두 close를 작성? no
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("금액 : ");
			int money = sc.nextInt();
			if(money <=0) 
				throw new Exception();
			
			System.out.println("인원 : ");
			int people = sc.nextInt();
			if(people <=0) 
				throw new Exception();
				sc.close();
			int price = money / people;
			int remain = money % people;
			
			System.out.println("한 명당 " + price + "원 씩 이체하시면 됩니다.");
			System.out.println("자투리금액 : " + remain + "원");
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
			 
	}
	

}

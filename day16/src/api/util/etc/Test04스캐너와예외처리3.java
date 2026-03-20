package api.util.etc;

import java.util.Scanner;

public class Test04스캐너와예외처리3 {
	public static void main(String[] args) {
		//해결을 위한 시도
		//-try~with~resource : close가 필요한 도구를 try에서만 사용할 경우 try내부에 별도의 공간을 두고 거기서 생성 (java8에서 나옴)
		//-finally없이도 자동 close가 됨
		//-(전제조건)AutoCloseable을 상속받아야함 
		
		try(
				Scanner sc = new Scanner(System.in)
		) {
			System.out.println("금액 : ");
			int money = sc.nextInt();
			if(money <=0) 
				throw new Exception();
			
			System.out.println("인원 : ");
			int people = sc.nextInt();
			if(people <=0) 
				throw new Exception();
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

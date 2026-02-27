package data;

public class Test05술값계산기 {
	public static void main(String[] args) {
		
		/*
		int price = 100000;
		int persontotal = 3;
		int person = price/persontotal;
		int cacaomoney = 1;
		
		//System.out.println(person);
		System.out.println(person*persontotal + cacaomoney);
		//System.out.println(100000);
		*/
		
		//입력
		int price = 100000;
		int people = 7;
		
		
		//처리
		int money = price / people;
		int remain = price % people;
	
		
		//출력
		System.out.println("한 사람이 낼 술 값은" + money + "원 입니다.");
		System.out.println("대박! 카카오페이에서 나머지" + remain + "원을 지원해드려요~!");
		

	}

}

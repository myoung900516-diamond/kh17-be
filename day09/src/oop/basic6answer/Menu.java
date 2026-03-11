package oop.basic6answer;

public class Menu {
	
	//멤버필드 : 데이터
	String category;
	String name;
	int price;
	boolean event;
	
	
	//멤버 메소드 : 기능(코드)
	//*같은 메소드를 다양한 형태로 만들어서 이용을 편하게 만들수있다 -> 메소드 오버로딩(method overloading)
	//*뭘 좋아할지 몰라서 다 준비해봤어
	void init(String category, String name, int price) {
		this.category = category;
		this.name = name;
		this.price = price;
		//this.event = false;
		
	}
	void init(String category, String name, int price, boolean event) {
		this.category = category;
		this.name = name;
		//맞지 않는 코드 show에서 처리해야함
//		if(event) {
//			this.price = this.price*90/100;
//		}
//		else { 
//			this.price = price;
//		}
		this.price = price;
		this.event = event;
	}
	
	void show() {
		System.out.println("<메뉴 정보>");
		System.out.println("분류 : " + this.category);
		if(this.event) {
			System.out.println("이름 : " + this.name + "(행사중)");
		}
		else { 
			System.out.println("이름 : " + this.name);
		}
		if(this.event) {
			int rate = 10;
			int discount = this.price * (100 - rate)/100;
			System.out.println("가격 : " + discount + "원( " + this.price + "원, " + rate + "%할인중)");
		}
		else {
			System.out.println("가격 : " + this.price + "원");
			
		}
		//System.out.println("행사 : " + this.event);
	}

}

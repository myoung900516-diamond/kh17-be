package oop.basic6;

public class CafeMenu {
	
	String category;
	String name;
	int price;
	boolean event; 
	
	
	void init(String category, String name, int price,boolean event ) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.event = event;
	}
	
	void show() {
		System.out.println("카테고리 : " + this.category);
		System.out.println("메뉴명 : " + this.name);
		
		if(event == true) {
			double sale =  price - (double)this.price * 0.1;
			this.price = (int)sale;
			//this.event = (행사상품);
			System.out.println("행사가 : " + this.price );
			System.out.println("행사여부 : 행사상품");
		}
		else { 
			System.out.println("판매가 : " + this.price);
			System.out.println("행사여부 : - ");

		}
	}
	

}

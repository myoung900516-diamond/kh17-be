package oop.method4;

public class LunchMenu {
	
	String name;
	String category;
	int price;
	int inventory;
    int discountRate;
	boolean delivery;
	
	void init(String name, String category, int price, int inventory, boolean delivery) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.inventory = inventory;
		this.delivery = delivery;
	}
	
	void init(String name, String category, int price, int inventory) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.inventory = inventory;
	}
	
	void init(String name, String category, int price, int inventory, int discountRate, boolean delivery) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.inventory = inventory;
		this.discountRate = discountRate;
		this.delivery = delivery;
	}
    void show() {
    	System.out.println("<메뉴제고현황>");
    	System.out.println("상품명 ; " + this.name);
    	System.out.println("분류 : " + this.category);
    	System.out.println("가격 : " + this.price + "원");
    	if(inventory == 0) {
    		System.out.println("재고없음");
    	}
    	else {    		
    		System.out.println("재고 : " + this.inventory + "개");
    	}
    	if(discountRate != 0) {
    		int salePrice = this.price * (100 - discountRate)/100;
    		System.out.println("할인율 : " + this.discountRate + "%, 할인된 가격 : " + salePrice + "원");
    		
    	}
    	else {
    	}
    	if(this.delivery) {
    		System.out.println("새벽배송가능여부 : 유");    		
    	}
    	
    }
	

}

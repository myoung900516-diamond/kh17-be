package oop.method4answer;

//상품 클래스
public class Product {
	//멤버 필드 
	String name;
	String category;
	int price;
	int stock;
	int discount;
	boolean early;
	
	//멤버 메소드
	//-오버로딩은 이름은 같되 매개변수의 개수 or 순서 or 형태 등이 달라서 구분이 가능해야 성립함
	void init(String name, String category, int price, int stock) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.discount = 0;
		this.early = false;
	}
	
	void init(String name, String category, int price, int stock, int discount) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.discount = discount;
		this.early = false;
	}
	
	void init(String name, String category, int price, int stock, boolean early) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.discount = 0;
		this.early = early;
	}
	
	void init(String name, String category, int price, int stock, int discount, boolean early) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.discount = discount;
		this.early = early;
	}
	
	void show() {
		System.out.println("[상품정보]");
	    System.out.println("이름 : " + this.name);
	    System.out.println("구분 : " + this.category);
	    if(this.discount == 0) {
	    	System.out.println("가격 : " + this.price + "원");	    	
	    }
	    else {
	    	int result = this.price * (100 - this.discount)/100;
	    	System.out.println("가격: " + result + "원 (원래 " + this.price + "원)");
	    }
	    if(this.stock > 0) {
	    	System.out.println("재고 : " + this.stock + "개");	    	
	    }
	    else {
	    	System.out.println("품절");
	    }
	    if(this.discount >0) {
	    	System.out.println("할인율 : " + this.discount + "%");	    	
	    }
	    if(this.early) {
	    	System.out.println("**새벽배송가능**");
	    }
	    //System.out.println("새벽배송여부 : " + this.early);
	}
	

}

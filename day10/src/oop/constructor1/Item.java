package oop.constructor1;
//상품
public class Item {
	private String name;
	private int price;
	private int stock;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0)return;
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		if(stock < 0)return;
		this.stock = stock;
	}
	//생성자(Constructor)
	
	//-객체 생성 시 반드시 설정할 정보를 받는 구문
	//-메소드처럼 생겼지만 메소드가 아님 클래스 이름과 무조건 똑같아야함.
	//-이름을 내 마음대로 지을수 없음. 대소문자까지 완벽히 똑같아야함
	//-생성 전용 초기화 구문
	//-필요하다면 오버로딩이 가능 
	//만약 재고를 언급하지 않으면 
	
	public Item(String name, int price) {
		this(name, price, 0);
	}
	public Item(String name, int price, int stock) {
		this.setName(name);
		this.setPrice(price);
		this.setStock(stock);
	}
	public void show() {
		System.out.println("<아이템 정보>");
		System.out.println("이름 : " + this.getName());
		System.out.println("가격 : " + this.getPrice());
		System.out.println("재고 : " + this.getStock());
	}

}

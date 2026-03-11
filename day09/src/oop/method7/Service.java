package oop.method7;

public class Service {
	String name;
	String category;
	int time;
	int price;
	String type;
	
	void setName(String name) {
		this.name = name;
	}
	void setCategory(String category) {
		switch(category) {
		case "재료", "소모품", "부품", "출력":
			this.category = category;
		}
	}
	void setTime(int time) {
		if(time < 0)return;
		if(time % 24 != 0)return;
		this.time = time;
	}
	void setPrice(int price) { 
		if(price < 0) return;
		if(price % 1000 != 0)return;
		this.price = price;
	}
	void setType(String type) {
		switch(type) {
		case "일반", "퀵", "방문수령":
			this.type = type;
		}
	}
	
	void init(String name, String category, int time, int price, String type) {
		this.setName(name);
		this.setCategory(category);
		this.setTime(time);
		this.setPrice(price);
		this.setType(type);
	}
		
		void show() {
			System.out.println("<서비스 목록>");
			System.out.println("부품명 : " + this.name);
			System.out.println("분류 : " + this.category);
			System.out.println("제작 소요시간 : " + this.time + "분");
			System.out.println("단가 : " + this.price + "원");
			System.out.println("배송방식 : " + this.type);
			
		
	}

}

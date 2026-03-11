package oop.method6answer;

public class Lecture {
	String title;
	String category;
	int duration;
	int price;
	String type;
	
	//String category = "abc";
	
	void setTitle(String title) {
		this.title = title;
	}
	void setCategory(String category) {
		switch(category) {
		case "이론", "실습", "시험":
		this.category = category;
		}
	}
	void setDuration(int duration) {
		if(duration < 0) return;
		if(duration % 30 != 0)return;
			this.duration = duration;			
	}
	void setPrice(int price) {
		if(price<0)return;
		if(price % 1000 != 0)return;
			this.price = price;			
	}
	void setType(String type) {
		switch(type) {
		case "온라인", "오프라인", "혼합":
		this.type = type;
		}
	}
	
	//-일반 메소드: init, show
	
	void init(String title, String category,int duration, int price) {
		this.init(title, category, duration, price, "오프라인");
	}
	void init(String title, String category,int duration, int price, String type) {
		this.setTitle(title);
		this.setCategory(category);
		this.setDuration(duration);
		this.setPrice(price);
		this.setType(type);
	}
	
	
	void show() {
		System.out.println("<강좌 정보>");
	    System.out.println("강좌명 : " + this.title);
	    System.out.println("분류 : " + this.category);
	    System.out.println("강의시간 : " + this.duration + "분");
	    System.out.println("수강료 : " + this.price + "원");
	    System.out.println("수업형태 : " + this.type);	    	
	}

}

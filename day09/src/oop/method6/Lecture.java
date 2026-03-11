package oop.method6;

public class Lecture {
	String name;
	String category;
	int time;
	int price;
	String type;
	
	//String category = "abc";
	
	void setName(String name) {
		this.name = name;
	}
	void setCategory(String category) {
		switch(category) {
		case "이론":
			this.category = category;
			break;
		case "실습":
			
			
		}
	}
	void setTime(int time) {
		if(time % 30 == 0) {
			this.time = time;			
		}
	}
	void setPrice(int price) {
		if(price % 1000 == 0 && price > 0) {
			this.price = price;			
		}
	}
	void setType(String type) {
		this.type = type;
	}
	
	void init(String name, String category, int time, int price) {
		this.setName(name);
		this.setCategory(category);
		this.setTime(time);
		this.setPrice(price);
		this.setType(null);
		
//		this.name =name;
//		this.category = category;
//		this.time = time;
//		this.price = price;
//		this.type = null;
	}
	
	void init(String name, String category, int time, int price, String type) {
		this.setName(name);
		this.setCategory(category);
		this.setTime(time);
		this.setPrice(price);
		this.setType(category);
//		this.name =name;
//		this.category = category;
//		this.time = time;
//		this.price = price;
//		this.type = type;
	}
	
	void show() {
		System.out.println("<강좌 정보>");
	    System.out.println("강좌명 : " + this.name);
	    System.out.println("분류 : " + this.category);
	    System.out.println("강의시간 : " + this.time + "분");
	    System.out.println("수강료 : " + this.price + "원");
	    if(this.type == null) {
	    	 System.out.println("수업형태 : 오프라인");
	    }
	    else {
	    	System.out.println("수업형태 : " + this.type);	    	
	    }
	}

}

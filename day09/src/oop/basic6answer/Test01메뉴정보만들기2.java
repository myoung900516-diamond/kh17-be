package oop.basic6answer;

public class Test01메뉴정보만들기2 {
	public static void main(String[] args) {
		
		//객체(인스턴스)생성
		Menu m1 = new Menu();
		Menu m2 = new Menu();
		Menu m3 = new Menu();
		Menu m4 = new Menu();
		
		
		//초기화
		m1.init("음료", "아메리카노", 2500, true);//행사중
		m2.init("음료", "고구마라떼", 3000);//행사안하는 건 아무말 없으면 행사안하는 줄 안다. 
		m3.init("디저트", "티라미수", 4000, true);//행사중
		m4.init("디저트", "마카롱", 2000);
		
		
		m1.show();
		m2.show();
		m3.show();
		m4.show();
		
		m1.event = false;
		m1.show();
	}

}

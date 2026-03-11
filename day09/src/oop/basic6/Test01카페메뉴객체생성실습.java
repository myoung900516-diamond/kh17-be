package oop.basic6;

public class Test01카페메뉴객체생성실습 {
	public static void main(String [] args) {
		
		CafeMenu a = new CafeMenu();
		CafeMenu b = new CafeMenu();
		CafeMenu c = new CafeMenu();
		CafeMenu d = new CafeMenu();
		
		
		a.init("음료", "아메리카노", 2500, true);
		b.init("음료", "고구마라떼", 3000, false);
		c.init("디저트", "티라미수", 4000, true);
		d.init("디저트", "마카롱", 2000, false);
		
		a.show();
		b.show();
		c.show();
		d.show();
		
	}

}

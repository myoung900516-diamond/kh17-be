package oop.method4;

public class Test01점심메뉴객체생성실습 {
	public static void main(String[] args) {
		
		LunchMenu a = new LunchMenu();
		LunchMenu b = new LunchMenu();
		LunchMenu c = new LunchMenu();
		LunchMenu d = new LunchMenu();
		
		a.init("비빔면", "라면", 16800, 2, true);
		b.init("크림대빵", "제과", 6500, 2);
		c.init("점보도시락", "라면", 8500, 3, 5, true);
		d.init("공간춘", "라면", 12300, 3, 20, false);
		
		
		a.show();
		b.show();
		c.show();
		d.show();
		
	}

}

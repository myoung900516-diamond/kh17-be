package oop.basic5;

public class Test01올림픽순위객체생성실습 {
	public static void main(String[] args) {
		
		Olympic2 a = new Olympic2();
		Olympic2 b = new Olympic2();
		Olympic2 c = new Olympic2();
		
		a.init(1, "미국", 40, 44, 42);
		b.init(2, "중국", 40, 27, 24);
		c.init(2, "일본", 20, 12, 13);
		
		System.out.println("<파리 올림픽 참여 국가 순위>");
		a.show();
		b.show();
		c.show();
	}

}

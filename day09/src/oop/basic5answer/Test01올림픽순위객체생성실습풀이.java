package oop.basic5answer;



public class Test01올림픽순위객체생성실습풀이 {
	public static void main(String[] args) {
		
		//객체 생성
		OlympicCountry a = new OlympicCountry();
		OlympicCountry b = new OlympicCountry();
		OlympicCountry c = new OlympicCountry();
		
		//객체 초기화
		a.init(1, "미국", 40, 44, 42);
		b.init(2, "중국", 40, 27, 24);
		c.init(2, "일본", 20, 12, 13);
		
		
		//객체 출력
		a.show();
		b.show();
		c.show();
	}

}

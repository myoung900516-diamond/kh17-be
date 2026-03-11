package opp.basic3;

public class Test01국가정보실습문제 {
	public static void main(String[] args) {
		
	
	Land a = new Land();
	Land b = new Land();
	Land c = new Land();
	
	//리모컨이 중요!!
	
	
	a.land = "아시아";
	a.country = "대한민국";
	a.city = "서울";
	a.population = 51700000L;
	
	b.land = "유럽";
	b.country = "프랑스";
	b.city = "파리";
	b.population = 68000000L;
	
	c.land = "북아메리카";
	c.country = "캐나다";
	c.city = "오타와";
	c.population = 40000000L;
	
	System.out.println("대륙 : " + a.land);
	System.out.println("국가명 : " + a.country);
	System.out.println("수도 : " + a.city);
	System.out.println("인구수 : 약" + a.population + "명");
	
	System.out.println("대륙 : " + b.land);
	System.out.println("국가명 : " + b.country);
	System.out.println("수도 : " + b.city);
	System.out.println("인구수 : 약" + b.population + "명");
	
	System.out.println("대륙 : " + c.land);
	System.out.println("국가명 : " + c.country);
	System.out.println("수도 : " + c.city);
	System.out.println("인구수 : 약" + c.population + "명");
	
	

			
	}

}

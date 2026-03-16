package oop.poly2;

public class Test01다형성주의시항 {
	public static void main(String[] args) {
		//Person을 만들어서 Teacher로 업캐스팅하고 차이점을 분석 
		//Teacher로 업캐스팅한다 = 출근
		
		Person p = new Person();
		p.drink();
		p.sing();
		p.explain();
		p.exam();
		
		//보관 형태를 변경Person -> Teacher, 업캐스팅 = 출근)
		Teacher t = p;
		//t.drink(); // 있는데 시야에 안보여서 안됨 
		//t.sing();//있지만 접근이 불가능해서 사용이 안됨
		t.explain();
		t.exam();
		
	
		
	}

}

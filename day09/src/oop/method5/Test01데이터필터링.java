package oop.method5;

public class Test01데이터필터링 {
	public static void main(String[] args) {
		Student a = new Student();
		
		a.init("테스트", -50, 600, 709);
		a.show();
		
		//문제1 : 값을 하나만 바구기가 어려움
		
		//문제2 : 값에 조건을 걸기가 어려움
		//a.korean = -50; 
		a.setKorean(-50);
		a.show();
	}

}

package oop.method6;

public class Test01강좌정보객체실습 {
	public static void main(String[] args) {
		
		Lecture l1 = new Lecture();
		Lecture l2 = new Lecture();
		Lecture l3 = new Lecture();
		Lecture l4 = new Lecture();
		Lecture l5 = new Lecture();
		
		l1.init("자바 프로그래밍 기초", "이론", 60, 5000000, "온라인");
		l2.init("파이썬 프로그래밍 기초", "이론", 90, 1000000, "오프라인");
		l3.init("정보처리기사 필기", "시험", 30, 300000, "혼합");
		l4.init("빅데이터 분석기사 실기", "시험", 120, 850000, "혼합");
		l5.init("빅데이터 분석기사 실기2", "시험", 120, 850000);
		
		l1.show();
		l2.show();
		l3.show();
		l4.show();
		l5.show();
		
		
	}

}

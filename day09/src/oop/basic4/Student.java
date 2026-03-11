package oop.basic4;

public class Student {
	
	//멤버 필드의 목적 ; 데이터 저장
	String name;
	int score;
	
	//멤버 메소드 : "자주 쓰는" 코드를 저장 
	//-기본 모양 : void 이름(준비물){코드}
	//-this : 주인공
	
//	void init(준비물) {
//		코드
//	}
	//-

//	void init(String n, int s) {
//		this.name = n;
//		this.score = s;
//	}
	
	void init(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	void show() {
		System.out.println("<학생 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("점수 : " + this.score);

	}
}

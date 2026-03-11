package oop.method5;

public class Student {
	
	//멤버 필드
	//정보를 받고 잘 입력했는지 검사&차단(필터링)
	String name;
	int korean, english, math;
	
	//세터메소드 
	//- 각자 모든 항목을 개별적으로 변경할 수 있는 메소드=문제1번해결
	//- 이름짓기 힘드니까 다음과 같이 규칙을 정하자!
	//-set과 필드이름을 합쳐서 메소드이름으로 설정하자!
	
	void setName(String name) {
		this.name = name;
	}
	
	void setKorean(int korean) {
		if(korean >= 0 && korean <= 100) {
			this.korean = korean;			
		}
	}
	//0~100점 사이일 경우 영어점수를 설정하는 세터메소드
//	void setEnglish(int english) {
//		if(english >= 0 && english <= 100) {
//			this.english = english;
//		}
//	} 괄호가 너무 많다.
	
	void setEnglish(int english) {
		if(english <0 || english > 100)return;
		this.english = english;
	}
	void setMath(int math) {
		if(math >= 0 && math <= 100) {
			this.math = math;
		}
	}

	//앞으로 모든 필드에 대한 설정은 세터메소드를 이용해서만 가능! 
	//멤버 메소드
	void init(String name, int korean, int english, int math) {
//		this.name = name; 
//		this.korean = korean;
//		this.english = english;
//		this.math = math;
		this.setName(name);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
		
	}
	
	void show() {
		System.out.println("이름 : " + this.name);
		System.out.println("국어 : " + this.korean);
		System.out.println("영어 : " + this.english);
		System.out.println("수학 : " + this.math);
		
	}

}

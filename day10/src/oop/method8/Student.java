package oop.method8;

public class Student {
	
	
	
	String name;
	int korean, english, math;
	

	void setName(String name) {
		this.name = name;
	}
	
	void setKorean(int korean) {
		if(korean >= 0 && korean <= 100) {
			this.korean = korean;			
		}
	}

	
	void setEnglish(int english) {
		if(english <0 || english > 100)return;
		this.english = english;
	}
	void setMath(int math) { //void는 실행시키면 뭔가 하긴 하지만 아무것도 얻을 수 없는 메소드 
		if(math >= 0 && math <= 100) {
			this.math = math;
		}
	}
//게터 메소드(getter method)
	//-데이터의 반환 또는 계산 결과를 알아내기 위한 메소드
	//-필드당 1개씩 만들고 필요하면 더 추가할 수 있음
	//-이름 규칙은 get + 필드명으로 한다
	//-return은 메소드 종료 및 데이터 반환을 수행하는 키워드
	
	String getName() {//실행시키면 String데이터 한 개를 얻을 수 있는 메소드 
		return this.name;
	}
	int getKorean() {
		return this.korean;
	}
	int getEnglish() {
		return this.english;
	}
	int getMath() {
		return this.math;
	}
	
	//필ㄷ가 없더라도 계사니 필요하면 만들 수 있다. (가상의 GETTER라 부를 예정)
	int getTotal() {
		return this.korean + this.english + this.math;
	}
	double getAverage() {
		return (double)this.getTotal()/3;
	}

	void init(String name, int korean, int english, int math) {

		this.setName(name);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
		
	}
	
	void show() {
		//System.out.println("이름 : " + this.name);
		System.out.println("이름 : " + this.getName());
		System.out.println("국어 : " + this.getKorean());
		System.out.println("영어 : " + this.getEnglish());
		System.out.println("수학 : " + this.getMath());
		System.out.println("총점 : " + this.getTotal());
		System.out.println("평균 : " + this.getAverage());
		//	int total = this.korean + this.english + this.math;
		//double average = (double)total / 3;
		//출력이 너무 길어~
		
	}

}

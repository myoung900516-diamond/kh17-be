package oop.modifier4;

import oop.modifier1.Car;

public class Test01공개접근 {
	public static void main(String[] args) {
		//(Q) 다른 패키지에 있는 클래스도 여기서 쓸 수 있을까? 
		//oop.modifier1.Car c = new oop.modifier1.Car();//oop.modifier1패키지에 있는 Car클래스의 객체를 생성해보자
		//전체 경로를 알려주며 사용하는 법 
		Car c = new Car();
		//-import로 경로를 미리 준비시켜 사용
		//근데 Car클래스가 퍼블릭이 아니면 무슨 방법을 써도 가져다 쓸 수 없음 
		
	}

}

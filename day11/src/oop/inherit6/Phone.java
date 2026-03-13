package oop.inherit6;
//상속을 위한 클래스
//-실제로 존재하지 않는 개념적인 내용을 담는 클래스.. 애매하다..
//-무슨 기능이 있어야하는 지는 알겠는데 어떻게 해야하는지는 말할 수 없다.
//-이런 경우 추상이라는 키워드를 활용한다. abstract
public abstract class Phone {//추상클래스 : 일반클래스에 추상메소드까지 가질 수 있는 상속 관계의 상위 클래스
	

	public abstract void on();//추상메소드: 있어야 하지만 설명할 수 없는 내용을 형식만 만들어둘때 사용 
	

	public abstract void off();
	
	public abstract void call();
}

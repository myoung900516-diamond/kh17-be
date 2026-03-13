package oop.inherit6;
//생성을 위한 클래스
//상속받은 매소드를 반드시 재정의를 해야한다.
public class IPhone17 extends Phone {

	@Override
	public void on() {
		System.out.println("사과 로고가 나오면서 전원이 켜집니다");
	}

	@Override
	public void off() {
		System.out.println("사과 로고가 나오면서 전원이 꺼집니다");
	}

	@Override
	public void call() {
		System.out.println("아이폰 음성통화 실해");
	}
	

}

package oop.inherit1;

//아이폰 17 휴대폰 클래스
public class IPhone17 {
	//멤버 필드
	private String color;
	private String number;
	//멤버 메소드
	public void call() {//전화를 걸수있는 기능이 있다. 
		System.out.println("전화걸기");
		}
	public void camera() {
		System.out.println("사진촬영");
	}
	public void sms() {
		System.out.println("문자메세지 전송");
		}
	public void applePay() {
		System.out.println("애플페이 결제");
	}
}

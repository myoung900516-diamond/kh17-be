package oop.inherit2;
//슈퍼글래스 혹은 상위 클래스 혹은 부모 클래스 위에이따
//-목적은 비슷한 클래스들이 공통점들을 보관하기 위한 클래스 
//-객체 생성이 목적이 아님 
public class Phone {
	//휴대폰이라면 가져야할 공통 필드
	private String color;
	private String number;
	//휴대폰이라면 가져야 할 공통 메소드 
	public void call() {//전화를 걸수있는 기능이 있다. 
		System.out.println("전화걸기");
		}
	public void camera() {
		System.out.println("사진촬영");
	}
	public void sms() {
		System.out.println("문자메세지 전송");
		}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}

package oop.multi1;

//메인 속성
//-필드, 메소드, 생성자, 추상메소드 정의
public abstract class Phone {
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public abstract void call();
	public abstract void sms();
	

}

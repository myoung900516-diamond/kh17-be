package oop.inherit4;
//하위클래스(기존에 우리가 만들던 클래스)
//-객체를 만들어서 어떤 기능을 이용하게 할 것인가를 고민 

public class GalaxyS26 extends Phone {
	//상속받은 메소드를 재정의
	//-완전히 똑같게 다시 만들어야함 
	public void pay() {
		System.out.println("삼성페이기능");
	}

	public GalaxyS26(String color, String number) {
		super(color, number);
	}

	public GalaxyS26(String color) {
		super(color);
	}
	

}

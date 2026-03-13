package oop.inherit4;
//상위클래스
//-하위클래스에서 내 기능들을 어떻게 이용할 것인가를 고민
public class Phone {
	private String color;
	//필드: 접근제한이 주요 이슈였죠
	//접근제한이 두 종류로 나눠짐
	//-private : 나 외에는 무조건 내가 시킨대로 해. 절대적으로 이 클래스에서 설정 및 반환을 모두 통제할 경우 사용
	//private String number;
	//-protected : 향후 상속받는 하위클래스에서 자유롭게 접근하여 원하는 형태로 사용 가능
	protected String number;
	//세터 게터는 이곳에 만듦 , 메소드지만 필드와 비슷함 

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	//메소드 
	//-재정의(Override)여부를 고려해야함 리모컨은 하위클래스부터 확인하고 있으면 쓰고(상위클래스는 확인 안한다) 없으면 상위클래스 확인한다. 
	//-상속관계에서만 사용가능함
	
	//-재정의를 금지시키고 싶으면 final 키워드 추가
	
//	public final void pay() {
//		System.out.println("결제기능");
//	}
	public void pay() {
		System.out.println("결제기능");
	}
	//생성자
	//-반드시 설정될 필드를 지정
	//-생성자를 만들면 하위클래스도 만춰야함
	public Phone(String color) {
		this.color = color;
	}
	public Phone(String color, String number) {
		this.color = color;
		this.number = number;
	}
	
	

}

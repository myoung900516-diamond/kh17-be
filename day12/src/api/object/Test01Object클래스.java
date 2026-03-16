package api.object;

public class Test01Object클래스 {
	public static void main(String[] args) {
		
		//Object 클래스의 객체 생성
		Object a = new Object();
		Object b = new Object();
		
		
		//메소드 사용
		//- 앞으로 우리가 만날 모든 클래스의 객체에는 일련번호(hashcode)가 붙는다
		//-일련번호가 주소인가요? 아니다! 자바는 절대로 주소가 표시되지 않는다(애뮬레이터방식 = 가상머신방식)
		//-일련번호는 자바의 버전이나 운영체제의 버전에 따라 달라질 수 있다. 
		System.out.println("a = " + a.hashCode());
		System.out.println("b = " + b.hashCode());
		
		//-객체의 요약정보를 확인할 수 있는 toString이란 메소드가 존재한다.
		//일련번호를 16진수로 표현됨@뒤에
		System.out.println("a = " + a.toString());
		System.out.println("b = " + b.toString());
		
	}

}

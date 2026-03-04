package data2;

public class Test01논리데이터 {
	public static void main(String[] args) {
		//논리데이터(boolean)
		//-숫자가 아니며 판정을 위한 데이터
		//-true, false 두 가지만 가질 수 있다
		//-숫자와 같은 연산이 불가능
		
		boolean a = true;
		boolean b = false;
		System.out.println(a);
		System.out.println(b);
		
		//-숫자를 이용해서 비교 등을 통해 true/false를 계산해서 저장하는 것이 목적
		//-비교 연산: 두 숫자를 비교해서 논리를 만드는 것(크다, 작다, 크거나 같다, 작거나 같다,같다,다르다)
		int battery = 15;//남은 배터리(%)
		boolean lowBattery = battery <= 15;
		System.out.println(lowBattery);
		
		int age = 25;
		boolean adult = age >=20;
		System.out.println(adult);
		
	}

}

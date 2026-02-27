package data;

public class Test04여러가지숫자 {
	public static void main(String[] args) {
		//정수: 소수점이 없는 수
		
		//-int는 약 42억개의 숫자 표현(-21억 ~ +21억)
		int a = 1000000000;
		System.out.println(a);
		
		//-long은 약 1800경개의 숫자 표현(-922경 ~ +922경)
		//int b = 10000000000; //안들어가면
		long b = 100000000000L; //더 큰 변수에 대입
		System.out.println(b);
		
		
		//실수 : 소수점이 있는 수 
		float c = 1.5f;
		double d = 1.5;
		System.out.println(c);
		System.out.println(d);
		
		//정수의 특징
		//-정수끼리 계산하면 정수가 나와요. 10/3=3 (특히 나눗셈 주의)
		
		System.out.println(10/3);//몫을 구하는 연산자
		System.out.println(10%3);//나머지를 구하는 연산자
		
		//실수의 특징
		//-실수가 포함되면 결과가 실수이다. 
		System.out.println(10/3.0);
		
		
	}

}

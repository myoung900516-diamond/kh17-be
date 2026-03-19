package api.lang.etc;

public class Test01수학연산클래스 {
	public static void main(String[] args) {
		//Math 클래스
		//-생선자가 없는(잠겨있는) 클래스 
		//-객체 생성을 아예 못하거나 아니면 생성 매소드를 제공하거나 (팩토리 or 싱글톤)
		//-전부다 static이면 객체 생성을 아예 못하는 경우
		//-static이 아닌 필드나 메소드가 단 한개라도 있다면 생성 매소드를 제공하는 경우
		//-Math는 객체 생성을 아예 못하는 케이스 (일회용 수학 연산에 특화된 클래스)
		
		//필드
		System.out.println(Math.PI);//원주율(자바에서 표현 가능한 최대치)
		//final 이 붙어서 상수(constant) 글자가 누워있음 
		
		//메소드
		//-절대값(absolute value) : 차이만 구하고 싶을 때 
		int a = 3000;
		int b = 3500;
		int c = Math.abs(a-b);
		System.out.println("차이 = " +c );
		
		//-반올림 : 0.5미만은 0으로, 0.5이상은 1로 만드는 처리 
		System.out.println(Math.round(1.4));
		System.out.println(Math.round(1.5));
		
		//-올림과 버림 
		System.out.println(Math.ceil(1.4));//올림
		System.out.println(Math.ceil(1.5));//올림
		System.out.println(Math.floor(1.4));//버림
		System.out.println(Math.floor(1.5));//버림
		
		//-제곱
		System.out.println(Math.pow(2, 10));//2의 10제곱
		
		//-제곱근(루트)
		System.out.println(Math.sqrt(9));//루트9
		
		//-밑변이 3, 높이가 4인 직각삼각형의 빗변의 길이는? 
		double row = 3;
		double height = 4;
		
		double row2 = Math.pow(row, 2);
		double height2 = Math.pow(height, 2);
		
		double k2 = row2 + height2;
		double k = Math.sqrt(k2);
		
		System.out.println("빗변의 길이는 = " + k );

		
		
		
	}

}

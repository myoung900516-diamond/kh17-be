package api.string;

public class Test03문자열클래스 {
	public static void main(String[] args) {
		//문자열(String)
		//-여러 개의 글자를 나열한 형태의 데이터(char 배열과 비슷...)
		//-**불변(immutable)**데이터
		
		String a = "Hello";//기존방식
		String b = "Hello";//기존방식
		String c = new String("Hello");//생성자 사용
		String d = new String("Hello");//생성자 사용
		
		
		//이 프로그램에서 Hello는 총 몇 개가 메모리에 저장되어 있을까요?
		// 정답:3개
				
		//(주의) 객체는 참조대상이 같아야 비교연상이 true가 나오기 때문에 사실상 사용이 어려움
		System.out.println( a==b); //a와 b는 동일한 대상을 가리킴 
		System.out.println( b==c); //b와 c는 다른 대상을 가리킴 
		System.out.println(c == d); //c와 d는 다른 대상을 가리킴 
		System.out.println(a == d); //a와d는 다른 대상을 가리킴 
		
		System.out.println("---------");
		//객체 비교는 equals 메소드로 한다 앞으로 쭉~
		System.out.println(a.equals(b));
		System.out.println(b.equals(c));
		System.out.println(c.equals(d));
		System.out.println(a.equals(d));
		
		
		
	}

}

package api.object;

public class StringBuffer {
	public static void main(String[] args) {
		
		/*
		객체 두 개를 생성
		첫 번째 객체는 a라는 이름으로 생성하며 비어있는 상태로 만듦
		두 번째 객체는 b라는 이름으로 생성하며 HelloWorld라는 문자열을 저장하여 만듦
		각각의 객체 안에 들어있는 글자수를 출력
		a에 KHacademy 문자열 추가
		b에 JavaProgramming 문자열 추가
		a에 저장된 글자를 거꾸로 뒤집어서 출력
		b에 저장된 글자를 5번 위치부터 10번 전까지 삭제한
		*/
		
		
		String a = new String();
		String b = new String("HelloWorld");
		
		System.out.println("객체 a의 글자수 : " + a.length() + "개");
		System.out.println("객체 b의 글자수 : " + b.length() + "개");
		
		// StringBuffer insert (int offset, string str) {
		//	System.out.println(a.insert(int 0, "KHacademy"));
//		StringBuffer append(String str) {			
//			System.out.println(a.append("KHacademy"));
//		}
//		a.appen
	}

}

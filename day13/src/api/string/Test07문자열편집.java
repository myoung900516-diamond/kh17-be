package api.string;

public class Test07문자열편집 {
	public static void main(String[] args) {
		//문자열편집
		//-기존문자열을 이용해서 신규 문자열을 만들어내는 변조 작업
		//-(중요)기존의 문자열은 절대로 변하지 않는다(문자열은 불변이다)
		
//		String a = "Hello";
//		a.toLowerCase();//소문자변환
//		System.out.println("a = " + a);
//		
		String a = "Hello";
		String b = a.toLowerCase();//소문자변환 후 결과를 저장
		System.out.println("a = " + b);
		
		
		System.out.println("대문자 = " + a.toUpperCase());//변환결과를 출력만 하고 저장은 안 하겠다.  
		
		//불필요한 여백제거
		String c = "                                               와 너무                  배고프고            집중이 안된다                          ";
		System.out.println("c = " + c);
		System.out.println("c = " + c.trim()); //불필요한 아스티 여백 제거(자바 모든 버전에거 가능)
		
		String d = "\u2003\u2003\u2003\u2003\u2003와 너무\u2003 배고프고 집중이 안된다\u2003\u2003";
		System.out.println("d = " + d.trim());
		System.out.println("d = " + d.strip());//유니코드 포함 모든 여백제거(자바11이상)
		
		//치환(바꾸기)
		String e = "자바 껌이네요";
		System.out.println("e = " + e);
		System.out.println("e = " + e.replace("자바", "피자").replace("껌이", "맛있"));
		
		
	}

}

package api.string2;

public class Test05이메일검사 {
	public static void main(String[] args) {
		String email1 = "apple123@gmail.com\r\n";
		String email2 ="abcde1@naver.co.kr\r\n";
		String email3 ="zxcvbn12@test-domain123.org";
		
		String emailA = "Abcde123@gmail.com";
		String emailB = "abcd@naver.com";
		String emailC = "abcde123@naver.c";
		
		//@을 기준으로 좌 조건식에 부합한다. 
		//좌 조건식 = 
		//-영문 소문자로 시작하며 숫자 포함 5~20글자
		String leftRegex = "^([a-z][a-z0-9]{4,19})$";
		//@을 기준으로 우 조건식에 부합한다. 
		//우 조건식 =
		
		
		
		boolean valid1 = email1.matches(leftRegex);
		boolean valid2 = email2.matches(leftRegex);
		boolean valid3 = email3.matches(leftRegex);
		boolean valid4 = emailA.matches(leftRegex);
		boolean valid5 = emailB.matches(leftRegex);
		boolean valid6 = emailC.matches(leftRegex);
		
		System.out.println(valid1);
		System.out.println(valid2);
		System.out.println(valid3);
		System.out.println(valid4);
		System.out.println(valid5);
		System.out.println(valid6);
		
	}

}

package api.string2;

import java.util.Scanner;

public class Test05이메일검사2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이메일을 입력하세요 :");
		
		String email = sc.next();
		
		String email1 = "apple123@gmail.com";
		String email2 ="abcde1@naver.co.kr";
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
		String rightRegex = "^([a-zA-Z0-9.-]{1,})[.]([a-zA-Z0-9]{2,})$";
		//@을 기준으로 왼쪽, 오른쪽 문자를 분리한다. 
		
//		String part [] = email1.split(rightRegex);
////		if(part) {
//		System.out.println(part);
////		}
////		앞쪽문자
		String front = email.split("@")[0];
		//System.out.println(front);
		
		//뒷쪽문자
		int where = email.indexOf("@");
		String back = email.substring(where+1, email.length());
		//System.out.println(back);
		
		//문자열 검사 
		boolean validF = front.matches(leftRegex);
		boolean validB = back.matches(rightRegex);
		
		if(validF && validB) {
			System.out.println("유효한 이메일입니다");
		}
		else {
			System.out.println("유효하지 않는 이메일입니다");
		}
		
		
	}

}

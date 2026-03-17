package api.string;

import java.util.Scanner;

public class Test04로그인프로그램 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요 id : ");
		String yourid = sc.next();
		System.out.println("비밀번호를 입력하세요 pw : ");
		String yourpwd = sc.next();
		
		String id = "khacademy";
		String pwd = "1234";
		
		String a = new String(yourid);
		String b = new String(yourpwd);
		
		if(a.equalsIgnoreCase(id) && b.equals/*IgnoreCase*/(pwd)) {//비밀번호는 대소문자 구분해야함 
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
	}

}

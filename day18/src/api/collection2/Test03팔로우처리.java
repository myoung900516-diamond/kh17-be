package api.collection2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test03팔로우처리 {
	public static void main(String[] args) {
		Set<String> user = new HashSet<>();
		
		user.add("testuser1");
		user.add("testuser2");
		user.add("testuser3");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		
		String testuser = sc.next();
		
		System.out.println("user = " + user);
		
		if(user.contains(testuser)) {
			user.remove(testuser);
			
		}
		System.out.println("user = " + user);
		
		
		for(String test : user) {
		//	System.out.println("아이디 입력 : " + user);
			System.out.println( user + " 님을 팔로우하였습니다.");
		}
		
	}

}

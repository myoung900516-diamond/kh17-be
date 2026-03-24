package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02로그인프로그램 {
	public static void main(String[] args) {
		Map<String, String> data = new HashMap<>();
		
		data.put("testuser", "test1234");
		data.put("student", "std1234");
		data.put("admin", "adm1234");
		data.put("client", "client");
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("아이디를 입력하세요.");
			String id = sc.next();
			if(!data.containsKey(id)) {
				System.out.println("유효하지 않은 아이디 입니다.");
				break;
			}
			System.out.println("비밀번호를 입력하세요.");
			String pwd = sc.next();
			if(!data.containsValue(pwd)) {
				System.out.println("비밀번호가 틀렸습니다.");
				break;
			}
			System.out.println("로그인 성공!");
		}
		
		
		sc.close();
		
	}

}

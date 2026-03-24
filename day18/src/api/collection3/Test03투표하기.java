package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03투표하기 {
	public static void main(String[] args) {
		Map<String, Integer> vote = new HashMap<>();
		
		//더미..데이터?
		vote.put("홍길동", null);
		vote.put("김수미", null);
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("이름을 입력하세요.");
		String name = sc.next();
		while(name.equals("종료")) {
			if(vote.containsKey(name)) {
				int i =1;
				vote.put(name, i);
				i++;
				System.out.println(name + "현재 " + i + "표 획득!");
			}
			else {
				vote.put(name, null);
				
			}
			
		}
	
		sc.close();
		
	}

}

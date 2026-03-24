package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test03투표하기2 {
	public static void main(String[] args) {
		Map<String, Integer> vote = new HashMap<>();
		//int i = 0;
		
		//더미..데이터?
		vote.put("홍길동",  0);
		vote.put("김수미", 0);
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("이름을 입력하세요.");
		
		while(true) {
			String name = sc.next();
			
			Set<String> names = vote.keySet();
			
			if(name.equals("종료")) {
				System.out.println("프로그램을 종료합니다");
				System.out.println("투표결과");
				for(String result : names) { 
					int count = vote.get(result);
					System.out.println(result + " : " + count + "표" );
				}
				break; 
			}
			if(vote.containsKey(name)){
				vote.put(name, vote.get(name) + 1 );
				System.out.println(name + "현재 " + vote.get(name) + "표 획득!");
			}
			else {
				vote.put(name, 1);
				System.out.println(name + " 현재 " + vote.get(name) + "표 획득!");
			}
			
		}
		
	
		sc.close();
		
	}

}

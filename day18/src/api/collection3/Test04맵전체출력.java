package api.collection3;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test04맵전체출력 {
	public static void main(String[] args) {
		//Map도 간단한 데이터 주고 불변 Map 생성이 되려나?
		
		Map<String, Integer> votes = Map.of(
				"BTS", 30, 
				"아이브", 20,
				"아이유", 20,
				"블랙핑크", 15
				);
		
		//개별 관리에 특화된 Map이더라도 혹시 전체 출력은 아예 안되나? 어렵습니다. 할 수는 있습니다. 
		//1. Map에서 Key만 보면 Set이므로 변환해서 사용
		Set<String>names = votes.keySet();//key만 set으로 변환
		for(String name : names) {
			int count = votes.get(name);
			System.out.println(name +" : " + count);
		}
		
		//2.Map에서 제공하는 중첩클래스인 Entry라는 것이 존재하는데 이를 사용(안 알려드리고 싶어요..)
//		Set<Map.Entry<String, Integer>> entries = votes.entrySet();
//		for(Map.Entry<String, Integer> entry : entries) {
		for(Entry<String, Integer> entry : votes.entrySet()) {
			System.out.println(entry.getKey() +" : "+ entry.getValue());
		}
		
		
		
	}

}

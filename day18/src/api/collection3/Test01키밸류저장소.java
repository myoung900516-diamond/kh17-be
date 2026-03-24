package api.collection3;

import java.util.HashMap;
import java.util.Map;

public class Test01키밸류저장소 {
	public static void main(String[] args) {
		//Map을 이용해서 이름(key)과 값(value)을 세트로 저장 
		//- 포켓몬의 "몬스터명"과 "속성"을 저장 
		//- 이름은 중복이 불가능하며, 값은 중복이 가능함 
		//- 이름(key)은 "몬승터명"을 사용 , 값(value)에는 "몬스터속성"을 사용
		
//		Map<몬스터명, 몬스터속성> monsters = new HashMap<>();
		Map<String, String> monsters = new HashMap<>();
		
		//데이터추가 - List, Set은 add()로 했으나 Map에서는 put(k, v)를 사용
		monsters.put("이상해씨", "풀");
		monsters.put("피카츄", "전기");
		monsters.put("라이츄", "전기");
		monsters.put("파이리", "불꽃");
		
		monsters.put("이상해씨", "독");//같은 key를 넣으면 value가 수정됨 
		
		
		//데이터개수 - List,Set과 동일한 명령 
		System.out.println("데이터 개수 = " + monsters.size() + " 세트");
		
		
		//출력
		System.out.println("monsters = " + monsters);
		
		//데이터검색- List, Set에서는 contains()를 썼는데, Map은 항목이 두 종류이다
		System.out.println("피카츄?" + monsters.containsKey("피카츄"));
		System.out.println("전기?" + monsters.containsValue("전기"));
		//데이터삭제- List, Set과 동일한 명령 
		monsters.remove("피카츄");
		//monsters.remove("전기");//안됨, 한개의 데이터를 특정할 수 없음
		
		
		//데이터 추출 List에서는 get()이었고, Set에서는 없는 명령
		System.out.println("피카츄 = " + monsters.get("피카츄"));
		System.out.println("라이츄 = " + monsters.get("라이츄"));
		
		
		System.out.println("monsters = " + monsters);
	}

}

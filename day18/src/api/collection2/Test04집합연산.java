package api.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test04집합연산 {
	public static void main(String[] args) {
		//Set을 이용한 집합 연산 예제
		//-종류 : 합집합(union), 교집합(intersection), 차집합(difference)
		//-각종 집합 관련 명령을 이용해서 해당 효과가 발생한 것처럼 보이게 계산 
		
		
		Set<Integer> a = Set.of(10, 20, 30, 40, 50);
		Set<Integer> b = Set.of(25, 30, 35, 40, 45);
		
		//합집합
		Set<Integer> union = new TreeSet<>();
		union.addAll(a);//a를 다 넣어라
		union.addAll(b);//b를 다 널어라
		System.out.println("합집합 = " + union);
		
		//교집합
		Set<Integer> intersection = new TreeSet<>();
		intersection.addAll(a);
		//intersection.removeAll(b); //b와 겹치는 부분을  
		intersection.retainAll(b); //b와 겹치는 부분만 남겨
		
		System.out.println("교집합 = " + intersection);
		
		//차집합
		Set<Integer> minus1 = new TreeSet<>();
		minus1.addAll(a);
		minus1.removeAll(b);
		System.out.println("A - B = " + minus1);
	}

}

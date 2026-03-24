package api.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test05음원차트분석 {
	public static void main(String[] args) {
		Set<String> melon = Set.of("SWIM", "Body to Body", "BANG BANG", "404", "RUDE!", "Good Goodbye", "Hooligan", "Drowning", "사랑하게 될 거야", "Aliens");
		Set<String> genie = Set.of("SWIM", "BANG BANG", "404", "Drowning", "Good Goodbye", "Body to Body", "사랑하게 될 거야", "타임캡슐", "RUDE!", "Golden");
		
//		양대 차트 모두 탑10에 포함된 노래
		//=교집합 
		
		
		Set<String> all = new TreeSet<>();
		all.addAll(melon);
		all.retainAll(genie);
		System.out.println("두군데 모두 포함된 노래 = " + all);
		for(String song1 : all) {
			System.out.println("→" + song1);
		}
		
		
		
//		둘 중 한 군데만 탑10안에 포함된 노래
		//=합집합 - 교집합 
		//합집합
		Set<String> bulk = new TreeSet<>();
		bulk.addAll(melon);
		bulk.addAll(genie);
		System.out.println("합집합 = " + bulk);
		//교집합 = all
		bulk.removeAll(all);
		
		System.out.println("둘 중 한군데만 포함된 노래 = " + bulk);
		for(String song2 : bulk) {
			System.out.println("→ " + song2);
		}
	}

}

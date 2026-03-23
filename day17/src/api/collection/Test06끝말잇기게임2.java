package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Test06끝말잇기게임2 {
	public static void main(String[] args) {
		List<String> offer = new ArrayList<>();
		
		offer.add("사과즙비타민정도");
		offer.add("강의실에어컨");
		offer.add("과일집아주머니");
		offer.add("화요일");
		offer.add("휴일날자는시간");
		offer.add("고용주님");
		offer.add("회사정문");
		offer.add("컴퓨터본체");
		offer.add("마우스패드");
		offer.add("어머니");
		
		Random r = new Random();
		int here = r.nextInt(9) + 1;
		
		String offer1 = offer.get(here);
		System.out.println("[제시어] = " + offer1);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("쿵쿵따→");
		String word = sc.next();
		System.out.println("쿵쿵따→");
		
		System.out.println(word.charAt(word.length()-1)); //입력한 값의 마지막 글자 출력
		
		boolean match = offer1.charAt(offer1.length()-1) == word.charAt(word.length()-1);//너무 길다
		System.out.println(match);
		if(match) { 
			System.out.println("게임오버");
		}
		
		if(word.length()< 2) {
			System.out.println("게임오버");
		}
		
		
	}

}

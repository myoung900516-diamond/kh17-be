package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Test06끝말잇기게임 {
	public static void main(String[] args) {
		List<String> offer = new ArrayList<>();
		
		//String[] offer = [] {"사과즙비타민정도", "강의실에어컨", "과일집아주머니", "화요일", "휴일날자는시간", "고용주님", "회사정문", "컴퓨터본체", "마우스패드", "어머니"}
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
		
		//offer배열에서 랜덤하게 한 단어 꺼내기 
		Random r = new Random();
		int here = r.nextInt(9) + 1;
		
		String offer1 = offer.get(here);
		System.out.println("[제시어] = " + offer1);
		
		
		//제시어와 관련된 단어 입력받기 
		Scanner sc = new Scanner(System.in);
		System.out.println("쿵쿵따→");
		String word = sc.next();
		System.out.println("쿵쿵따→");
		
		//연결되지 않는 경우
		//String a = "고용주님";
		//word.charAt(word.length());
		System.out.println(word.charAt(word.length()-1)); //입력한 값의 마지막 글자 출력
		
		boolean match = offer1.charAt(offer1.length()-1) == word.charAt(word.length()-1);//너무 길다
		System.out.println(match);
		
		//System.out.println(word.endsWith(offer1.charAt(offer1.length()-1)));
		
		//글자수는 2글자 이상이다 
		if(word.length()< 2) {
			System.out.println("게임오버");
		}
		
		
	}

}

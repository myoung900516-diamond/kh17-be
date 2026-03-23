package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08포커게임 {
	public static void main(String[] args) {
		//문자,숫자 배열
		List<String> number = new ArrayList<>();
		number.add("A");
		number.add("2");
		number.add("3");
		number.add("4");
		number.add("5");
		number.add("6");
		number.add("7");
		number.add("8");
		number.add("9");
		number.add("10");
		number.add("J");
		number.add("Q");
		number.add("K");
		
		//모양배열
		List<String> shape = new ArrayList<>();
		shape.add("하트");
		shape.add("스페이드");
		shape.add("클로버");
		shape.add("다이아");
		
		//한 덱deck을 구현
		List<String> card = new ArrayList<>();
	//	System.out.println( shape.get(0) + number.get(0) );//이게 똑같은게 안나오면서 52장 나와야함 
		int i = 0;
		//for(i = 0 ; i < 52 ; i ++) {
		while(card.size()<52) {
			
			Collections.shuffle(shape);
			Collections.shuffle(number);
			
			String shape1 = shape.get(0);
			String number1 = number.get(0);
			String card1 = shape1 + number1;
			
			if(card.contains(card1)==false) {
				
				card.add(card1);
			}
				
		}
		System.out.print("한 deck = " + card);
		//한덱을 셔플함
		Collections.shuffle(card);
		//유저 4명의 리스트를 만듬
		List<String> user1 = new ArrayList<>();
		List<String> user2 = new ArrayList<>();
		List<String> user3 = new ArrayList<>();
		List<String> user4 = new ArrayList<>();
		
		//각 유저에게 셔플한 card 배열에 0~5, 6~11, 12~17, 18~23 위치에 있는 문자를 부여한다 
		//=배열의 몇 번째 문자를 때어넨다
		System.out.println("");
		user1.add(card.get(0));
		user1.add(card.get(1));
		user1.add(card.get(2));
		user1.add(card.get(3));
		user1.add(card.get(4));
		user1.add(card.get(5));
		System.out.println("user1 = " + user1);
		
		System.out.println("");
		user2.add(card.get(6));
		user2.add(card.get(7));
		user2.add(card.get(8));
		user2.add(card.get(9));
		user2.add(card.get(10));
		user2.add(card.get(11));
		System.out.println("user2 = " + user2);
		
		System.out.println("");
		user3.add(card.get(12));
		user3.add(card.get(13));
		user3.add(card.get(14));
		user3.add(card.get(15));
		user3.add(card.get(16));
		user3.add(card.get(17));
		System.out.println("user3 = " + user3);
		
		System.out.println("");
		user4.add(card.get(18));
		user4.add(card.get(19));
		user4.add(card.get(20));
		user4.add(card.get(21));
		user4.add(card.get(22));
		user4.add(card.get(23));
		System.out.println("user4 = " + user4);
		
	}

}

package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08포커게임2 {
	public static void main(String[] args) {
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
		
		List<String> shape = new ArrayList<>();
		shape.add("하트");
		shape.add("스페이드");
		shape.add("클로버");
		shape.add("다이아");
		
		List<String> card = new ArrayList<>();
		int i = 0;
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
		Collections.shuffle(card);
		
		List<String> user1 = new ArrayList<>();
		List<String> user2 = new ArrayList<>();
		List<String> user3 = new ArrayList<>();
		List<String> user4 = new ArrayList<>();
		
		
		System.out.println("");
		for(i = 0; i<6 ; i++) {
		user1.add(card.get(i));
		}
		System.out.println("user1 = " + user1);
		
		System.out.println("");
		for(i = 6; i< 12; i++) {
		user2.add(card.get(i));
		}
		System.out.println("user2 = " + user2);
		
		System.out.println("");
		for(i = 12; i <18; i++) {
		user3.add(card.get(i));
		}
		System.out.println("user3 = " + user3);
		
		System.out.println("");
		for(i = 18; i <24; i++) {
		user4.add(card.get(i));
		}
		System.out.println("user4 = " + user4);
		
	}

}

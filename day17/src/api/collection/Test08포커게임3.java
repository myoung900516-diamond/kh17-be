package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08포커게임3 {
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
		Collections.shuffle(card);
		System.out.println(" ");
		System.out.println("[플레이어1]");
		for(i = 0; i<6 ; i++) {
			System.out.println("→ " +card.get(i));
		}
		
		System.out.println("[플레이어2]");
		for(i = 6; i< 12; i++) {
			System.out.println("→ " + card.get(i));
		}
		
		System.out.println("[플레이어3]");
		for(i = 12; i <18; i++) {
			System.out.println("→ " + card.get(i));
		}
		
		System.out.println("플레이어4]");
		for(i = 18; i <24; i++) {
			System.out.println("→ " + card.get(i));
		}
		
	}

}

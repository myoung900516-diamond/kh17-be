package api.collection2;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test02로또번호생성기 {
	public static void main(String[] args) {
		Set<Integer> number = new TreeSet<>();
		
		Random r = new Random();
		
		int i = 0;
		for(i = 0; i<12; i++) {
			int num = r.nextInt(45) + 1;
			i++;
//			number.add(num);
//			if(number.contains(num)) {
//				i--;
//				number.add(num);
//			}
			number.add(num);
			System.out.println("로또번호 = " + number);
		}
	}

}

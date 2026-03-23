package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test03로또번호생성기 {
	public static void main(String[] args) {
		
		//1~45에서 랜덤한 정수 나오기
		
		Random r = new Random();
		int num = r.nextInt(45) + 1 ;
		//System.out.println(num);
		List<Integer> lucky = new ArrayList<>();
		
		//6개 나오기 
		int i = 0;
		
		for (i = 1; i<= 6; i++) {
			int numSixth = r.nextInt(45) + 1 ;
			
		//	System.out.println(numSixth);
		
		//배열로 묶기 
		lucky.add(numSixth);
		//중복이 있는지 검증하기 
		lucky.contains(numSixth);
		System.out.println(lucky.contains(numSixth));
		}
		//System.out.println(lucky);
		
		//순서대로 출력하기 
		Collections.sort(lucky);
		System.out.println(lucky);
	
		
	}

}

package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test03로또번호생성기2 {
	public static void main(String[] args) {
		
		
		Random r = new Random();
		int num = r.nextInt(45) + 1 ;
		List<Integer> lucky = new ArrayList<>();
		
		//int i = 0;
		
		//for (i = 1; i<= 6; i++) {
		while(lucky.size()<6) {
			int numSixth = r.nextInt(45) + 1 ;
			
			if(!lucky.contains(num)) {//숫자 묶음에 있는 숫자가 아닐때만 넣어라. (=중복검사)
				lucky.add(numSixth);
			}
		}
		
		Collections.sort(lucky);//=number.sort(null);
		System.out.println("이번주 로또 번호 = " + lucky);
	
		//중복이 있는지 검증하기 
		//0번 위치부터 5번위치까지 다 확인?!
		//
	//	lucky.contains(lucky);
	//	System.out.println(lucky.contains(lucky));
		
	}

}

package api.string;

import java.util.Scanner;

public class Test08욕설필터링3 {
	public static void main(String[] args) {
		String[] filter = new String[] {"십자수", "십장생", "수박씨", "신발", "시베리아", "십칠팔번"};
		int[] stars = new int[filter.length];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력하세요");
		String line = sc.nextLine();//한 줄(엔터 전까지)을 입력받는 명령
		
		String xx = "";
		for(int i=0; i < filter.length; i++) {
			if(i > 0) xx += "|";
			xx += filter[i];
			stars[i] = filter[i].length();
			System.out.println(filter[i].length());
		}
		System.out.println("xx = " + xx);
	//	String zz = "*";
	//	String star = "*".repeat(stars);
		
//		for(i = 0; i <= xx.length(); i++) {
//			
//		}
		//String yy = line.replaceAll(xx, star);
		
		//System.out.println(yy);
		
	
	}

}

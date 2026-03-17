package api.string;

import java.util.Scanner;

public class Test06쿵쿵따게임3 {
	public static void main(String[] args) {
		String start = "화요일";

		System.out.println("쿵쿵따 게임 ");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("시작 : " + start + " → ");
			String next = sc.next();
			//next = new String(start);
			if(next.length() != 3) 
				break;
			if( next.charAt(0) != start.charAt(start.length()-1) ) break;
				System.out.println(next + "→");
				//next = start;
				start = next;
				}
		System.out.println("게임오버");
	}
}

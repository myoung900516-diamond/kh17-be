package api.string;

import java.util.Scanner;

public class Test06쿵쿵따게임2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("쿵쿵따 게임 ");
		System.out.println("시작 : 화요일 → ");
		
		String start = "화요일";
		
		while(true) {
			String next = sc.next();
			//next = new String(start);
			if(next.length() != 3) {
				System.out.println("게임오버");
				break;
			}
			else if( next.charAt(0) != start.charAt(start.length()-1) ) {
				System.out.println("게임오버");
				break;
			}
			else {//3글자고, 화요일의 마지막글자와 첫번째 글자가 같은 경우 
				//String next1 = new String(next);
				System.out.println(next + "→");
			//	next = new String(start);
			}
		}
	}
}

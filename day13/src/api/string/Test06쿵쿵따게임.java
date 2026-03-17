package api.string;

import java.util.Scanner;

public class Test06쿵쿵따게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("쿵쿵따 게임 ");
		System.out.println("시작 : 화요일 → ");
		String next = sc.next();
		
		while(true) {
			if(next.length() == 3 && next.charAt(0) == next.charAt(next.length()-1) ) {
				String next1 = new String(next);
				System.out.println(next1 + "→");
				String next2 = sc.next();
			}
			else {
				System.out.println("게임오버");
				break;
			}
			
		}
	}
}

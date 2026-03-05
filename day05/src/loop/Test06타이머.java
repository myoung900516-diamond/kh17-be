package loop;

import java.util.Scanner;

public class Test06타이머 {
	public static void main (String[] args) {
		//입력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("분을 입력하세요");
		int m = sc.nextInt();
		System.out.println("초를 입력하세요");
		int s = sc.nextInt();
		
		
		System.out.println("해당 시간은 " + m+ "분" + s + "초 입니다." );

		//처리
		int second = m * 60 + s;

		for (int i = second ; i >= 0 ; i--) {
			//System.out.println(i);
			int showM = i /60;
			int showS = i % 60;
			System.out.println(showM + "분 " + showS + "초 후 알람이 울립니다.");
			
			
			}
		System.out.println("★★★ 시간이 다 되었습니다!★★★");

		}
		
		
		
		//출력
		
		
		
	}



package condition;

import java.util.Scanner;

public class Test02지각판정기3 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("입실시각 : ");
		int time = sc.nextInt();  
		
		
		//처리
		int hour = time/100;
		int minute = time%100;
		int convert = hour * 60 + minute;
		
		int stdHour = 9;
		int stdMinute = 10;
		
		int standard = stdHour * 60 + stdMinute;;
		
		boolean safe = convert <= standard;
		
		
		//출력
		if(safe == true) {
			System.out.println("정상 출력입니다.");

		}
		if(safe == false) {
			System.out.println("지각입니다.");

		}
		
		
	}

}

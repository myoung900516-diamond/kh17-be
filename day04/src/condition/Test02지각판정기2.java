package condition;

import java.util.Scanner;

public class Test02지각판정기2 {
	public static void main(String[] args) {
		//입력
		int time = 905; //왜 오류? 
		//숫자표기법 
		// -2진수 : 표기 방법이 없음
 		// - 8진수: 앞을 '0'으로 시작
		// -10진수: 원래 하던대로 작성
		// -16진수: 앞으로 '0x'로 시작
		
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

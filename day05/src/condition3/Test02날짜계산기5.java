package condition3;

import java.util.Scanner;

public class Test02날짜계산기5 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("년도를 입력하세요.");
		int year = sc.nextInt();
		System.out.println("월을 입력하세요.(숫자만 입력)");
		int month = sc.nextInt();
		//int month = 10;
		
		//int year = 2020;
		
		//처리
		//1월 31일
		//2월 28일
		//3월 31일
		//4월 30일
		//5월 31일
		//6월 30일
		//7월 31일
		//8월 31일
		//9월 30일
		//10월 31일
		//11월 30일
		//12월 31일
		//boolean leap = 400의 배수 || (100의배수아님 && 4의배수); //윤년은 leap year라고 함
		boolean leap = year % 400 ==0 || (year % 100 != 0 && year % 4 == 0); //윤년공식(가지고 있는게 좋음)
		int days;
		switch(month) {
		default:  //default 위에 와도 됨.
			days = 31;
			break;
		case 2:
			if(leap) //윤년이면)
				{
				days = 29;
			}
			else {
			days = 28;
			}
			break;
		case 4: case 6: case 9: case 11:
			days = 30;
			break;
		}
		
		
		//출력
		System.out.println(month +"월은 " + days + "일까지 있습니다.");

	}

}

package condition3;

import java.util.Scanner;

public class Test02날짜계산기3 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요.(숫자만 입력)");
		int month = sc.nextInt();
		//int month = 10;
		
		
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
		
		switch(month) {
		default:  //default 위에 와도 됨.
			System.out.println("31일까지 있습니다.");
			break;
		case 2:
			System.out.println("28일까지 있습니다.");
			break;
		case 4: case 6: case 9: case 11:
			System.out.println("30일 있습니다.");
			break;
		
		}
		
		
		//출력
		//System.out.println("?월은 ?일까지 있습니다.");

	}

}

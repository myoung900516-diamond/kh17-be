package condition2;

import java.util.Scanner;

public class Test03지하철요금계산기 {
	public static void main(String[] args) {
		
		
		//입력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("출생년도를 입력하세요.");
		int a = sc.nextInt();
		
	//	int a = 1990;
		int year = 2026;
		int back = 500;
		
		
		//처리
		int old = year - a + 1;
		
		int price;
		if(old >= 65) {
			price = 0;
		}
		else if(old>= 20 && old <= 64) {
			price = 1550 + back;
		}
		else if(old>= 14 && old <= 19) {
			price = 900 + back;
		}
		else if(old>= 8 && old<= 13) {
			price = 550 + back;
		}
		else {
			price = 0;
		}
		
		
		
		
		
		//출력
		System.out.println("요금 : " + price + "원");
		
	}
	

}

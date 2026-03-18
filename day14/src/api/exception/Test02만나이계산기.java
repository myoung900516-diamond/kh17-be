package api.exception;

import java.time.LocalDate;
import java.util.Scanner;

public class Test02만나이계산기 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("생년월일을 입력하세요");
		String birth = sc.nextLine();
		//String birth = "1990-05-16";
		
		//처리
		
		//년도만 int로 변환하자 
		String front = birth.substring(0, 4);
		//int year = Integer.sub
		int year = Integer.parseInt(front);
		System.out.println(front);
		
		int age =LocalDate.now().getYear() - year + 1;
		System.out.println("현재 나이 : " + age + "세");
		
		//월만 int로 변환하자 
		String middle = birth.substring(5, 7);
		System.out.println(middle);
		int month = Integer.parseInt(middle);
		System.out.println(month);
		
		//개월수를 구하자 
		
		int y2 = age -1; 
		int m2 = LocalDate.now().getMonthValue() - month;
		int m = y2*12 + m2;
		
		System.out.println(m + "개월");
		
		//만나이를 구하자 
		
		int y3 = m/12;
		//출력
		System.out.println("만나이 : " + y3 + "세");
		
	}


}

package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test06기념일계산기 {
	
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜를 입력하세요");
		System.out.println("연도 : ");
		int year = sc.nextInt();
		System.out.println("월: ");
		int month = sc.nextInt();
		System.out.println("일: ");
		int day = sc.nextInt();
		
		
		//처리
		Calendar c = Calendar.getInstance();
		
		c.set(year, month - 1, day);
		
		c.get(Calendar.YEAR);
		c.get(Calendar.MONTH);
		c.get(Calendar.DATE);
		c.get(Calendar.DAY_OF_YEAR);
		
		//입력 날짜를 1일로 바꾸려면 
		int firstDay = c.get(Calendar.DAY_OF_YEAR) - c.get(Calendar.DAY_OF_YEAR) + 1;
		//c.add(firstDay, firstDay + 1); //이거는 상수가 아니쟈나 
		//int dDay = c.add(firstDay, firstDay + 1);
		//int dDay = Integer.par
		
		//100일 기념일 구하기
//		c.set(Calendar.DATE, firstDay + 100);
//		Date d = c.getTime();
//		Format f = new SimpleDateFormat("yyyy-MM-dd");
		
		//100일마다 800일까지 기념일 구하기 
		int i = 0;
		for(i=1; i<=8; i++) {
			c.set(Calendar.DATE, firstDay + 100*i);
			Date d = c.getTime();
			Format f = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("D + " + 100*i + " : " + f.format(d));
		}
		
		
		//1주년 기념일 구하기 
		c.set(Calendar.DATE, firstDay * 365);
		Date d2 = c.getTime();
		Format f2 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("D + 365 : ");
		
		//출력
		
		//System.out.println(firstDay + "첫날입니다");
		//System.out.println(c.add(firstDay, firstDay + 1));
	}

}

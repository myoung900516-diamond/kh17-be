package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test07급여일계산기4 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입사년월일을 입력하세요");
		System.out.println("연도 : " );
		int year = sc.nextInt();
		System.out.println("월: " );
		int month = sc.nextInt();
		System.out.println("일 : " );
		int firstday = sc.nextInt();

		
		System.out.println("'현재시점 : " + year +"-0"+ month +"-"+ firstday + "'");
		Calendar c = Calendar.getInstance();
		
		
		
		int i = 0;
		for(i=1; i<=12; i++) {
			c.set(year, month-1, 5);
			int day = c.get(Calendar.DAY_OF_MONTH);
			
			c.add(c.get(Calendar.MONTH), i);
			if(c.get(Calendar.DAY_OF_WEEK) == 1) {
				c.set(day, 3);
				Date d = c.getTime();
				Format f =  new SimpleDateFormat("yyyy-MM-dd");
				System.out.println("'급여일 = " + f.format(d) + "'");
			}
			else if(c.get(Calendar.DAY_OF_WEEK) == 7) {
				c.set(day, 4);
				Date d = c.getTime();
				Format f =  new SimpleDateFormat("yyyy-MM-dd");
				System.out.println("'급여일 = " + f.format(d) + "'");
			}
			else { 
				Date d = c.getTime();
				Format f =  new SimpleDateFormat("yyyy-MM-dd");
				System.out.println("'급여일 = " + f.format(d) + "'");
			}
		}
		//만약, 그 달의 5일이 휴일이면? 그 전날이 급여일 
		//만약 그 달의 5일이 주말인데 금요일도 휴일이면? 
		//그냥 그 전날 불러와주는 메소드는 없나? 
		//그 달의 5일이 주말 혹은 휴일이면 휴일 아닌 전 일로 가라.. 
		//평일이 나올때까지 이 짓을 반복해야함. While-break;
		
		//2026년도 법정 공휴일 
		//2026-01-01,2026-02-16,2026-02-17,2026-02-18,2026-03-01,2026-05-05,2026-05-24,2026-05-25,
		//2026-06-03,2026-06-06,2026-07-17,2026-08-15,2026-08-17,2026-09-24,2026-10-3,2026-10-05,
		//2026-10-09,2026-12-25
		
		//그 달의 5일이 월,화,수,목,금 이면 통과
		//급여일의 조건
		//-주말이면 안됨
		//-휴일이면 안됨 
		//그 달의 급여일이 
		//주말이면 금요일로 바뀜
		//휴일이면 바로전 금요일로 바뀜
		
		//그 달의 급여일이 주말이면 금요일로 바뀜 ,
		//휴일인 월요일이면 바로전 금요일로 바뀜, 
		//휴일에 걸리면 전일로 바뀜, 
		//휴일인 주말이면 금요일로 바뀜
		
	}

}

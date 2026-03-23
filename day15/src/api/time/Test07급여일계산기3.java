package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test07급여일계산기3 {
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
		
	}

}

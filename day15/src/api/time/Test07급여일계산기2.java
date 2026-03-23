package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test07급여일계산기2 {
	public static void main(String[] args) {
		//현재 시점을 입력
		int year = 2026;
		int month = 3;
		int day1 = 19;
		
		//급여일 = 매월 5일 (일단 주말 생각하지 않고)
		Calendar c = Calendar.getInstance();
		
		
		
		//현재시점 출력
		//System.out.println(f.format(d));
		
		//다음 급여일은 2026-04-05 / 2026-05-05
		//1개월만 더해봄
//		c.add(c.get(Calendar.MONTH), 4);
//		Date d = c.getTime();
//		Format f =  new SimpleDateFormat("yyyy-MM-dd");
//		
		//개월수를 추출해서 하나씩 12개월까지 더하자 
		
		int i = 0;
		for(i=1; i<=12; i++) {
			c.set(year, month-1, 5);
			int day = c.get(Calendar.DAY_OF_MONTH);
		//	System.out.println(day);
			
			c.add(c.get(Calendar.MONTH), i);
			if(c.get(Calendar.DAY_OF_WEEK) == 1) {
				c.set(day, 3);
		//		System.out.println(day);
				Date d = c.getTime();
				Format f =  new SimpleDateFormat("yyyy-MM-dd");
				System.out.println("'급여일 = " + f.format(d) + "'");
			}
			else if(c.get(Calendar.DAY_OF_WEEK) == 7) {
				c.set(day, 4);
		//		System.out.println(day);
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
		
		//주말은 언제일까
		c.get(Calendar.DAY_OF_WEEK); //이거가 1또는 7임. 
		//만약 그 달의 5일이 주말이면 월급은 금요일날 들어옴. 
		//그럼 그주의 금요일은? 바로 6
		
	//	if(c.get(Calendar.DAY_OF_WEEK) == 1 || c.get(Calendar.DAY_OF_WEEK) == 7) {
			//금요일로 줄력해라. 그 전에 금요일로 바꿔줘야함. 
			//c.set(c.get, i); 한꺼번에 바꾸는 건 모르겠다. 
			//하나씩 바꾸자 
			//만약 그 달의 5일이 일요일이라면 
			
	//	}
//		if(c.get(Calendar.DAY_OF_WEEK) == 1) {
//			c.set(year, month-1, 5);
//			c.set(c.get(Calendar.DATE), -2);
//			Date d = c.getTime();
//			Format f =  new SimpleDateFormat("yyyy-MM-dd");
//			System.out.println("'급여일 = " + f.format(d) + "'");
//			
//		}
	}

}

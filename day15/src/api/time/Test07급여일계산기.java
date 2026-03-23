package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test07급여일계산기 {
	public static void main(String[] args) {
		//현재 시점을 입력
		int year = 2026;
		int month = 3;
		int day = 5;
		
		//급여일 = 매월 5일 (일단 주말 생각하지 않고)
		Calendar c = Calendar.getInstance();
		
		c.set(year, month-1, day);
		
		Date d = c.getTime();
		Format f =  new SimpleDateFormat("yyyy-MM-dd");
		
		//현재시점 출력
		System.out.println(f.format(d));
		
		//day뽑아내기 
		
		c.get(Calendar.DATE);
		
		//month뽑아내기
		
		c.get(Calendar.MONTH); //= month -1월 
		int m = c.get(Calendar.MONTH) + 1;
		
		//5일마다 날짜 추출하기 
		
		int i = 0;
		for(i=0; i<=12; i++) {
			if(c.get(Calendar.DATE) == 05);{
				c.add(c.get(Calendar.MONTH), 1);
				System.out.println("'급여일 : " + f.format(d) + "'");
			}
		}
		//출력
		System.out.println("급여일 = 2025-08-05");
		System.out.println("급여일 = 2025-08-05");
		System.out.println("급여일 = 2025-08-05");
		System.out.println("급여일 = 2025-08-05");
		System.out.println("급여일 = 2025-08-05");
		System.out.println("급여일 = 2025-08-05");
		System.out.println("급여일 = 2025-08-05");
		System.out.println("급여일 = 2025-08-05");
		System.out.println("급여일 = 2025-08-05");
		System.out.println("급여일 = 2025-08-05");
	}

}

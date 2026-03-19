package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Test04랜덤날짜추첨기 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		Date d = c.getTime();
		Random r = new Random();
		int mont = r.nextInt(365) + 1;
		
		Format f = new SimpleDateFormat("M월 d일");
		System.out.println(f.format(d));
		
		c.set(2026, 0, mont);
	
		
		c.get(Calendar.MONTH);
		System.out.println(c.get(Calendar.MONTH));
		int month = c.get(Calendar.MONTH);
		System.out.println(month);
		
		int mon = r.nextInt(12) + 1;
		System.out.println("랜덤한 월 = " + mon + "월");
		
		c.get(Calendar.DATE);
		
		System.out.println((c.get(Calendar.MONTH)+1) + "월" + c.get(Calendar.DATE) + "일");
		
		
	}

}

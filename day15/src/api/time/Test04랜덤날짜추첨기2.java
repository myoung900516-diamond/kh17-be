package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Test04랜덤날짜추첨기2 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		Random r = new Random();
		
		
		c.get(Calendar.MONTH);
		c.get(Calendar.DATE);
		c.get(Calendar.DAY_OF_WEEK);
		
		while(true) {
			int mont = r.nextInt(365) + 1;
			
			c.set(2026, 0, mont);
			if((mont + 2) % 7 == 5 || (mont + 2) % 7 == 6) break;
			System.out.println("랜덤한 날짜 : " + "'2026년 " + (c.get(Calendar.MONTH)+1) + "월" + c.get(Calendar.DATE) + "일");// + c.get(Calendar.DAY_OF_WEEK)+ "요일");
			
		}

		
		//System.out.println( c.get(Calendar.DAY_OF_WEEK));
	}

}

package api.time;

import java.util.Calendar;

public class Test05달력만들기 {
	public static void main(String[] args) {
		
		int year = 2026;
		int month = 8;
		
		//해당하는 달의 달력을 보여주세요.
		
		//해당 월이 무슨 요일로 시작하는지 알아야함. 
		//전원이 무슨 요일로 끝났는지 알아야함. 
		Calendar c = Calendar.getInstance();
		
		c.set(year, month -1 , 1);
		
		c.get(Calendar.DAY_OF_WEEK);
		System.out.println(c.get(Calendar.DAY_OF_WEEK)); //7=토요일
		c.get(Calendar.DATE);
		
		//2026.8.1 은 일요일
		System.out.println("                                   " + year + "년" + month + "월                   " );
		System.out.println("일           월             화            수               목                금               ");
		System.out.println();
		
		
	}
	

}

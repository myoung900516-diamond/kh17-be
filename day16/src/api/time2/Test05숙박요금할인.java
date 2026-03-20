package api.time2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Test05숙박요금할인 {
	public static void main(String[] args) {
		//입력 
		int price = 300000;
		//체크인 날은? 
		String checkIn = "2026-03-20";
		//체크아웃 날은? 
		String checkOut = "2026-03-25";
		
		
		//체크인 날을 localdate 클래스의 변수로 변환 
		
		LocalDate checkInDay = LocalDate.parse(checkIn);
		System.out.println("체크인 하는 날 = " + checkInDay);
		
		LocalDate checkOutDay = LocalDate.parse(checkOut);
		System.out.println("체크아웃 하는 날 = " + checkOutDay);
		
		//숙박 하는 일수 = 5일 = 25- 20
		System.out.println("숙박하는 일수 = " + ChronoUnit.DAYS.between(checkInDay, checkOutDay) + "일");
		
		//숙박 요금 = 일수 * 1박 요금
		System.out.println("숙박요금 = " + price * ChronoUnit.DAYS.between(checkInDay, checkOutDay) +"원"  );
		
		
		//숙박하는 날에 요일은? 
		System.out.println("체크인 날이 요일 = " + checkInDay.getDayOfWeek());
	}

}

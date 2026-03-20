package api.time2;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Test03기간연장계산기 {
	public static void main(String[] args) {
		//발생비용 = 연장개월수 * 1개월당 비용
		
		//입력
		int price = 12000;
		int month = 4; 
		System.out.println("연장할 기간(개월) = " + month);
		//현재날짜 
		LocalDate today = LocalDate.now();
		
		//만료일 
		LocalDate end = today.plusMonths(month);
		LocalDate end2 = end.minusDays(1);
		
		//만료일의 요일은? 
		System.out.println("만료일의 요일은? =" + end2.getDayOfWeek());
		int total = price * month;
		
		
		//주말인가? . 
		String week = end2.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);
		switch(week) {
			case "토":
				end2 = end2.plusDays(1L);
			case "일": 
				end2 = end2.plusDays(1L);
		}
		
		
		
		//처리 
		
		//출력
		System.out.println("예상 만료일 = " + end2);
		System.out.println("예상 결제금액 = " + total + "원 입니다.");
		
	}

}

package api.time;

import java.util.Calendar;

public class Test05달력만들기 {
	public static void main(String[] args) {

		//입력
		int year = 2026;
		int month = 1;
		
		//처리
		//- 가장 중요한건 1일이 무슨요일인지 알아내는 것
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DATE, 1);
		int week = c.get(Calendar.DAY_OF_WEEK);
		//System.out.println("week = " + week);
		
		//변경해야 하는 일요일의 날짜는 (year)년 (month)월 (-week+2)일이다
		c.set(Calendar.DATE, -week+2);//날짜를 직접 설정
		//c.add(Calendar.DATE, -week+1);//1일에서 앞으로 이동시켜 설정
		
		//출력
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i=1; i <= 42; i++) {
			int m = c.get(Calendar.MONTH) + 1;
			if(m == month) {
				System.out.print(c.get(Calendar.DATE));
			}
			System.out.print("\t");
			
			//7의 배수가 아니라 토요일 출력 후 엔터를 치는걸로 조건을 변경(가독성이 좋아짐)
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			if(dayOfWeek == Calendar.SATURDAY) {
				System.out.println();
			}
			
			//c.add(Calendar.DATE, 1);//하루 뒤로 이동
			int day = c.get(Calendar.DATE);//날짜추출
			c.set(Calendar.DATE, day+1);//다음날로 재설정
		}
	}
}
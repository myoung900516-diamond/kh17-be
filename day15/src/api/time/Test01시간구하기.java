package api.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01시간구하기 {
	public static void main(String[] args) {
		//1.System 클래스 사용
		long time = System.currentTimeMillis();
		System.out.println("시간 = " + time);
		
		//2.java.util.Date클래스 사용
		Date a = new Date(); //현재시각
		Date b = new Date(2026, 3,19); //2026년 3월 19일?
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		//사람들이 원하는 형식으로 변환해주는 도구를 사용(java.text.SimpleDateFormat클래스)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(a));
	}

}

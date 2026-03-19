package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test03캘린더클래스2 {
	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance(); 
		//시간을 변경하는 방법
		//-우리가 배운 변경메소드(세터)는 set +필드명 
		//-예전(20년전즈음)에 만들어진 클래스들은 이 규칙을 따르지 않았음
		//c.setYear(2000);//우리가 알고있는 setter의 형태
		//c.set(항목,, 값);//과거의 setter형태
		//c.set(Calendar.YEAR, 2000);//과거의 setter형태
		//c.set(Calendar.MONTH, Calendar.JANUARY);
		//c.set(Calendar.DAY_OF_MONTH, 1);
		//C.set(Calendar.DATE, 1);
		
		c.set(2000, 0, 1);
		
		//그럼 혹시 getter메소드는? 
		//System.out.println("연도 : " + c.getYear()); 
		System.out.println("연도 : " + c.get(Calendar.YEAR));  //Calendar의 방식
		
		
		//Calendar는 Date로 변환이 가능 
		Date d = c.getTime();
		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(f.format(d));
		
		
		}

}

package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02시간출력형식지정 {
	public static void main(String[] args) {
		Date a = new Date();
		
		//SimpleDateFormat sdf1 = new SimpleDateFormat("y년 M월 d일 E a h시 m분 s초");
		Format sdf1 = new SimpleDateFormat("y년 M월 d일 E a h시 m분 s초");//업캐스팅 (업캐스팅을 최대한 많이 써야함 그렇다고 Object로 하면 안됨. 지금 쓸 수 있는 가장 최상위형태를 써야함))
		String date1 = sdf1.format(a);
		System.out.println("'" + date1 + "'");
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date2 = sdf2.format(a);
		System.out.println("'" + date2 + "'");
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("a h:mm");
		String date3 = sdf3.format(a);
		System.out.println("'" + date3 + "'");
		
	}

}

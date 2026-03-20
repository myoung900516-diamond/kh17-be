package api.util.etc;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Random;

public class Test01랜덤클래스3 {
	public static void main(String[] args) {
		//Random클래스
		//-초기값(시드,seed)을 이용해서 어떤 계산을 통해 원하는 범위의 랜덤데이터를 만드는 클래스 
		//-유사랜덤데이터를 생성
		
		Random r = new Random();
		
		//시드를 조작해서 OTP번호 생성(10초간 동일)
		long time = System.currentTimeMillis();
		r.setSeed(time/1000);//OTP비밀번호 
		
		int otp = r.nextInt(1000000);
		
		System.out.println("OTP = " + otp);
		
		DecimalFormatSymbols symbol = new DecimalFormatSymbols();
		symbol.setGroupingSeparator(' ');
		DecimalFormat f = new DecimalFormat("000,000", symbol);
		//콤마를 띄어쓰기로 바꿔주는 설정 
		//개조할 때는 업캐스팅을 하면 안됨 
	
		System.out.println("OTP = " + f.format(otp));
	}

}

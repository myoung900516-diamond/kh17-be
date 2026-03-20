package api.util.etc;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Random;
import java.util.UUID;

public class Test01랜덤클래스4 {
	public static void main(String[] args) {
		//Random클래스
		//-초기값(시드,seed)을 이용해서 어떤 계산을 통해 원하는 범위의 랜덤데이터를 만드는 클래스 
		//-유사랜덤데이터를 생성
		
		Random r = new Random();
		long time = System.currentTimeMillis();
		//시드를 조작해서 OTP번호 생성(10초간 동일)
		//-주의사항 : 이용자가 여러명일 경우 각자 다른 시드가 나와야함(이 역할을 보통 일련번호가 함)
		String user1 = "88e9cf32-1db2-4b50-a4f0-44407b45aab8";
				//UUID.randomUUID().toString();//랜덤 시리얼번호(중복없음)
		String user2 ="192cf039-bb40-443a-b4f9-0488e2c13f20"; 
				//UUID.randomUUID().toString();//랜덤 시리얼번호(중복없음)
		System.out.println("user1 = " + user1);
		System.out.println("user2 = " + user2);
		
		//시드 역시 두 개로 나워서 생성
		long seed1 = user1.hashCode() + System.currentTimeMillis()/5000;
		long seed2 = user2.hashCode() + System.currentTimeMillis()/5000;
		r.setSeed(seed1);
		int otp1 = r.nextInt(1000000);
		r.setSeed(seed2);//OTP비밀번호 
		int otp2 = r.nextInt(1000000);
		
		DecimalFormatSymbols symbol = new DecimalFormatSymbols();
		symbol.setGroupingSeparator(' ');
		DecimalFormat f = new DecimalFormat("000,000", symbol);
		//콤마를 띄어쓰기로 바꿔주는 설정 
		//개조할 때는 업캐스팅을 하면 안됨 
	
		System.out.println("OTP = " + f.format(otp1));
		System.out.println("OTP = " + f.format(otp2));
	}

}

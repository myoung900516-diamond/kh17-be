package random;

import java.util.Random;

public class Test01랜덤데이터 {
	public static void main(String[] args) {
		//랜덤(Random)데이터
		//-어느 데이터가 나올지 예측이 안되는 값
		//-범위는 알 수 있음 (사람과 다르게 ?부터 ?개로 설정) 사람은 ?부터 ?까지라고 말함. 
		//앞에 사건이 뒤에 사건에 영향을 주지 않음. 
		//-생성하는 방법이 여러가지가 있음 
		//-완벽한 랜덤은 없음
		//-주사위, 동전, 로또, 아이템뽑기, ...(대부분 정수)
		
		//방법1: Math.random()명령사용
		
		//System.out.println(Math.random());
		/*
	     double a = Math.random(); //0이상 1미만 double
	     double b = a * 6; //0이상 6미만 double
	     int c = (int)b; //0이상 6미만 int(0, 1, 2, 3, 4, 5)
	     int d = c + 1; //1이상 7미만 int(1, 2, 3, 4, 5, 6)
	     System.out.println("d = " + d);
	     */
		int d = (int)(Math.random() * 6) + 1; //1부터 6개 
		System.out.println("d = " + d);
		
	     //방법2: 랜덤 생성 도구를 만들어서 사용 (앞으로 사용할 방법)
		Random r = new Random();
		int dice = r.nextInt(6) + 1; //주사위
		System.out.println("dice = " + dice);
		
		
		//(Q)로또번호 1개를 추첨하여 출력 ( 1부터 45까지 = 1부터 45개)
		
		int rotto = r.nextInt(45) + 1;
		System.out.println("로또번호는 " + rotto + "입니다.");
		
		//(Q) 8자리 OTP번호를 추첨(반드시 8자리여야함)
		//- 10000000부터 9999999999까지 (10000000부터 90000000개)
		int otp = r.nextInt(90000000) + 10000000;
		System.out.println("otp = " + otp);
		
	     
	}

}

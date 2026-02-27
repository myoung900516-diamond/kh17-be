package data;

public class Test02영화요금계산기 {
	public static void main(String[] args) {
		
		int adult = 15000; //성인요금
		int youth = 9000; //청소년요금
		int kid = 5000;  //어린이요금
		
		int adultCount = 2; //성인 인원수
		int youthCount = 1; //청소년 인원수
		int kidCount = 2;  //어린이 인원수 
		
		int adultTotal = adult * adultCount; //성인요금합
		int youthTotal = youth * youthCount; //청소년요금합
		int kidTotal = kid * kidCount; //어린이요금합
		
		int total = adultTotal + youthTotal + kidTotal; //총합
		
		System.out.println(total);

		
	}

}

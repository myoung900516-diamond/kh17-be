package data;

public class Test02영화요금계산기 {
	public static void main(String[] args) {
		
		int adult = 15000;
		int youth = 9000;
		int kid = 5000;
		
		int adultCount = 2;
		int youthCount = 1;
		int kidCount = 2;
		
		int adultTotal = adult * adultCount;
		int youthTotal = youth * youthCount;
		int kidTotal = kid * kidCount;
		
		int total = adultTotal + youthTotal + kidTotal;
		
		System.out.println(total);

		
	}

}

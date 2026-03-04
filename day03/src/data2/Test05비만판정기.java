package data2;

public class Test05비만판정기 {
	public static void main(String[] args) {
		
		//입력
		//double height = 1.8;
		double height = 180;
		double weight = 80;
		
		double m = height/100;
		
		
		//처리
		double height2 = m*m;
		//int bmi = weight/height2 + weight%height2;
		double a = weight/height2;
		//double b = weight%height2;
		//boolean BMI = 23<= bmi && bmi <=24.9;
		boolean bmi = 23<= a && a <= 24.9;
		
		//결과
		//System.out.println(BMI);
		System.out.println(bmi);
		//System.out.println(a);
		//System.out.println(b);
		System.out.println(a);
		
	}

}

package data2;

import java.util.Scanner;

public class Test05비만판정기2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("키(cm) 입력하세요");
		double cm = sc.nextDouble();
		System.out.println("체중(kg) 입력하세요");
		double kg = sc.nextDouble();
		
		
		
		double m = cm/100;
		
		
		//처리
		double height2 = m*m;
		//int bmi = weight/height2 + weight%height2;
		double a = kg/height2;
		//double b = weight%height2;
		//boolean BMI = 23<= bmi && bmi <=24.9;
		boolean bmi = 23<= a && a <= 24.9;
		
		//결과
		//System.out.println(BMI);
		System.out.println(bmi);
		//System.out.println(a);
		//System.out.println(b);
		System.out.println(a);
		
		sc.close();
	}

}

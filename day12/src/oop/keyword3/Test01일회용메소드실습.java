package oop.keyword3;

public class Test01일회용메소드실습 {
	public static void main(String[] args) {
		int a = 4;
		int b = 9;
		
		int mul = Calculator.multiple(a, b);
		System.out.println("multiple ; " + mul);
		
		int c = 8;
		int squ = Calculator.square(c);
		System.out.println("square : " + squ);
		
		int d = 8;
		int e = 5;
		double tri = Calculator.triangle(d, e);
		System.out.println("triangle : " + tri);
		
		int f = 5;
		double cir = Calculator.circle(f);
		System.out.println("circle : " + cir);
		
		double g = 165;
		double h = 48;
		//double i = g/100;
		double bm = Calculator.bmi(g, h);
		System.out.println("bmi : " + bm);
		
		
		
	}

}

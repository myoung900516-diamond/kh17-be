package oop.keyword3;

import java.util.Random;

public class Calculator {
	public static int multiple(int a, int b) {
		return a * b;
	}
	public static int square(int c) {
		return c * c;
	}
	public static double square(double c) {
		return c * c;
	}
	public static double triangle(int d, int e) {
		return d * e / 2.0;
	}
	public static double circle(double f) {
		return f* f * 3.14;
	}
	public static double bmi(double g, double h) {
		double i = g /100;
		//double 
		//return h/square(i);
		return h/(i * i);
		//return  j;
	}
	public static int subway(int k) {
		if( k >= 20 && k < 65) return 1550;
		if(k >=14 && k < 20) return 900;
		if(k >= 9 && k < 14) return 500;
		return 0;
	}
//	public static int subway(int i) {
//
//	}
	
	public static int random(int l, int m) {
		Random r = new Random();
		int n = m - l +1;
		return r.nextInt(n) + l;
	}

}

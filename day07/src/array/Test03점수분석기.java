package array;

import java.util.Scanner;

public class Test03점수분석기 {
	public static void main (String[] args) {
		
		int a = 80, b = 50, c = 95, d = 91, e = 72;
		
		System.out.println("개별점수 : " + a);
		System.out.println("개별점수 : " + b);
		System.out.println("개별점수 : " + c);
		System.out.println("개별점수 : " + d);
		System.out.println("개별점수 : " + e);
		
		int great = 0;
		if(a>= 90) great ++;
		if(b>= 90) great ++;
		if(c>= 90) great ++;
		if(d>= 90) great ++;
		if(e>= 90) great ++;
		System.out.println("90점 이상 인원수 = " + great);
		
		int bad = 0;
		if(a < 60) bad++;
		if(b < 60) bad++;
		if(c < 60) bad++;
		if(d < 60) bad++;
		if(e < 60) bad++;
		System.out.println("60점 미만 인원수 = " + bad);
		
		int total = a + b + c + d + e;
		
		double average = total/5;
		System.out.println("평균 점수는 : " + average);
		
		
		
	}

}

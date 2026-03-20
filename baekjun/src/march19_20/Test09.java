package march19_20;

import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int a = sc.nextInt();
		int b = sc.nextInt();
//		int a = 472;
//		int b = 385;
//		
		//b를 무엇으로 나눠서 5가 나올까 
		int b380 = b/10*10; 
		int b5 = b%b380; 
		
		int ab3 = a*b5;
		
		//b를 무엇으로 나눠서 8이 나올까 
		int b300 = b/100*100;
		int b85 = b - b300;
		int b8 = b85/10;
		
		int ab4 = a * b8;
		
		
		//b를 무엇으로 나눠서 3이 나올까 
		int b3 = b/100;
		
		int ab5 = a * b3;
		
		//a * b의 결과값은? 
		int ab6 = ab3 + ab4*10 + ab5*100;
		
		System.out.println(ab3);
		System.out.println(ab4);
		System.out.println(ab5);
		System.out.println(ab6);
		 sc.close();
	}

}

package march25_26;

import java.util.Scanner;

public class Test10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		long a1 = sc.nextLong();
		long b1 = sc.nextLong();
		long c1 = sc.nextLong();
		
		int a = 77;
		int b = 77;
		int c = 7777;
		
		int result = a + b + c;
		long result1 = a1 + b1 + c1;
		
		System.out.println(result);
		System.out.println(result1);
		
		sc.close();
	}

}

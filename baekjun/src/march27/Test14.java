package march27;

import java.util.Scanner;

public class Test14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		if(a > b) {
			System.out.println(">");
		}
		if(a < b) {
			System.out.println("<");
		}
		if(a == b) {
			System.out.println("==");
		}
		sc.close();
	}

}

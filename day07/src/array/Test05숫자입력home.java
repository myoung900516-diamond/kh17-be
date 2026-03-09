package array;

import java.util.Scanner;

public class Test05숫자입력home {
	public static void main(String[] args) {
		
		int[] numbers = new int[10];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 10개를 입력하세요");
		for(int i = 0; i < numbers.length; i++) {
		//	int a = numbers[i];
		//	System.out.println("숫자 = " + numbers[a]);
			// a = sc.nextInt();
			System.out.println("숫자 입력 : ");
			numbers[i] = sc.nextInt();
		}
		int odd = 0;
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] % 2 == 1) {
				odd ++;
			}
		}
		System.out.println("홀수의 개수 : " + odd + "개");
		
		int max = numbers[0];
		for(int i = 0; i <numbers.length; i++) {
			if(max < numbers[i]) {
				max = numbers[i];
				
			}
		}
		System.out.println("가장 큰 수는 " + max);
//			if(numbers[i] >= numbers[i + 1]) {
//			}
//		}
//			System.out.println(numbers[i]);
//			else {
//			}
//			System.out.println(numbers[i + 1]);
//			
//		
//		if(numbers[0] >= numbers[1]) {
//			System.out.println(numbers[0]);
//		}
//		else {
//			System.out.println(numbers[1]);
//		}
		
	}

}

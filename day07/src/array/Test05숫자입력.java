package array;

import java.util.Scanner;

public class Test05숫자입력 {
	public static void main(String[] args) {
		
		int[] number = new int[10];
		int odd = 0;
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 10개를 입력하세요");
		for(int i = 0; i <number.length; i++) {
			count ++;
			System.out.println("숫자 입력" + count + ": ");
			number[i] = sc.nextInt();
		}
		
		for(int i = 0; i < number.length; i++) {
			if(number[i] % 2 == 1) {
				odd ++;
			}
		}
		System.out.println("홀수의 개수 : " + odd + "개");
		
		for(int i = 0; i < number.length; i++) {
			if(number[i]>number[i] ){
			}
			System.out.println("가장 큰 수는 " + number[i]);
		}
	}
	

}

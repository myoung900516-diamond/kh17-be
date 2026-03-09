package array;

import java.util.Scanner;

public class Test05숫자입력2 {
	public static void main(String[] args) {
	
		//입력(배열 준비)
		int[] numbers = new int[10];
		int odd = 0;
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < numbers.length; i++) {
		System.out.print("숫자입력 : ");
		
		numbers[i] = sc.nextInt(); 
		}
		
		//홀수개수
		for(int i = 0; i < numbers.length; i ++) {
			if(numbers [i] % 2 ==1) {
				//System.out.println("홀수 = " + numbers[i]);
				odd++;
			}
		}
		System.out.println("홀수 개수 = " + odd);
	
		//가장 큰 수
		int max = numbers[0];//+0지점 데이터가 가장 크다고 치고
		for(int i  = 1; i <numbers.length; i++) {
			if(max < numbers[i]) {
				max = numbers[i];
			}
		}
		System.out.println("가장 큰 수 : " + max);
		
	}
	

}

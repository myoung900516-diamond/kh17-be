package loop2;

import java.util.Scanner;

public class Test02약수찾기 {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int a = sc.nextInt();
		
	//	int a = 100;
		int count = 0;
		
		for(int i = 1 ; i <= a ; i++) {
			//i = i + 1;
			if(a % i == 0) {
				count ++;
			}
		}
		System.out.println(a + "의 약수의 개수는" + count + "개 입니다");
		
		
	}

}

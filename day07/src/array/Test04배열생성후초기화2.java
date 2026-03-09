package array;

import java.util.Scanner;

public class Test04배열생성후초기화2 {
	public static void main(String[] args) {
		//배열을 비어있는 상태로 만들 수는 없나? 
		//int[] a = new int[] {0, 0, 0, 0, 0};
		int[] b = new int[3]; //개수를 알려주고 생성(자동으로 초기값 설정)
		
		
		//초기화
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < b.length; i++) {
		System.out.print("숫자입력 : ");
		b[i] = sc.nextInt();}
		
		
		//출력
		for(int i = 0 ; i < b.length; i ++) {//b배열 전체를 반복하며
			System.out.println(b[i]);//b의 시작점에서 +i떨어진 곳의 데이터를 출력
		}
	}

}

package array;

import java.util.Random;
import java.util.Scanner;

public class Test06메뉴추천프로그램5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메뉴 개수 : ");
		int count = sc.nextInt();
		String[] menuList = new String[count];
		for(int i = 0; i<menuList.length; i++) {
			System.out.print("메뉴 입력 : ");
			menuList[i] = sc.next();
		}
		//단순화시켜 구현
		//String[] menuList = new String[] {"떡볶이", "치킨", "파스타"};
//		String[] menuList = new String[3];
//		menuList[0] = "떡볶이";
//		menuList[1] = "치킨";
//		menuList[2] = "파스타";
		
		Random r = new Random();
		int p = r.nextInt(count) ; // 0부터 3개
		
		System.out.println("추천메뉴는 " + menuList[p] + "입니다");//0,1,2중 하나 
		
		
		
		
	

}
}

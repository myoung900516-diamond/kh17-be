package array;

import java.util.Random;
import java.util.Scanner;

public class Test06메뉴추천프로그램home {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴 개수 : " );
		int count = sc.nextInt();
	//	int count = 3;
		//int[] menu = new int[3];
		String[] menuList = new String[count];
		int number = 0;
		for(int i = 0; i < menuList.length; i++) {
			number ++;
			System.out.print(number + ". 메뉴 : ");
			menuList[i] = sc.next();}
		//String[] menuList = new String[] {"비빔밥", "청국장", "라면"};
		
		
	//	for(int = i; i < menuList.length; i++) {
		Random r = new Random();
		//int menuList[i] = r.nextInt(3);
		//String menuList = r.nextString(3);
		
	//	for(int i = 0; i < menuList.length; i++) {
			int a = r.nextInt(count);
			System.out.println("오늘의 추천 메뉴 : " + menuList[a]);
		//}
	}

}

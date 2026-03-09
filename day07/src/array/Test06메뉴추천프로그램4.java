package array;

import java.util.Random;
import java.util.Scanner;

public class Test06메뉴추천프로그램4 {
	public static void main(String[] args) {
		

		String[] menuList = new String[] {"비빔밥", "샌드위치", "라면"};
//		String[] menuList = new String[3];
//		menuList[0] = "비빔밥";
//		menuList[1] = "샌드위치";
//		menuList[2] = "라면";
//		
		Random r = new Random();
		int p = r.nextInt(3);
		
		System.out.print(menuList[p]);
		
		
	

}
}

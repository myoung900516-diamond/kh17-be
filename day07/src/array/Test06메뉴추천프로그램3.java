package array;

import java.util.Random;

public class Test06메뉴추천프로그램3 {
	public static void main(String[] args) {
		
		//단순화시켜 구현
		//String[] menuList = new String[] {"떡볶이", "치킨", "파스타"};
		String[] menuList = new String[3];
		menuList[0] = "떡볶이";
		menuList[1] = "치킨";
		menuList[2] = "파스타";
		
		Random r = new Random();
		int p = r.nextInt(3) ; // 0부터 3개
		
		System.out.println(menuList[p]);//0,1,2중 하나 
		
		
		
		
	

}
}

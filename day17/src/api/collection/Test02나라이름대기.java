package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test02나라이름대기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("나라 이름을 입력하세요");

		String land = "";
		
		//String a = "한국";
		
		List<String> countryList = new ArrayList<>();
		
	//	int i = 0;
		//입력하는 나라를 배열에 계속 추가하기 
		//while(true) {
			while(true) {
				String nextLand = sc.next();
				countryList.add(nextLand);
				
			if(nextLand.equals(land)) break;
			
			}
	//		
			System.out.println("나라이름 = " + countryList);
	//	}
		
		
	}

}

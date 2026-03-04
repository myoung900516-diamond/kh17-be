package data2;

public class Test02성인판정프로그램 {
	public static void main(String [] args) {
		//입력
		int user = 20260303;
		
		
		
		//처리
		//-나이 : 태어난 해부터 현재까지 거쳐온 연도수 (올해-태어난해+1)
		int year2 = user/10000;
		int year = 2026;
		int age = 2026 - year + 1;
		boolean adult = age >= 20;
		
		
		//출력
		System.out.println(age);
		System.out.println(adult);
		System.out.println(year2);
		

	
	}

}

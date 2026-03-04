package data2;

public class Test07건강검진대상자 {
	public static void main(String[] args) {
		/*
		//입력
		int birth = 1990;
		int year = 2026;
		
		
		
		//처리
		int old = year - birth + 1;
		System.out.println(old);
		boolean subject = old >= 30;
		System.out.println(subject);
		
		
		
		//결과
		System.out.println(true);
		*/
		//입력
		
		int birth = 1995;
		int year = 2025;
		
		int age = year - birth + 1; //한국 나이 계산 
		
		
		//계산 과정을 생략하고 결과만 가지고 조합
		boolean over30 = age >= 30;
		boolean yearEven = year % 2 == 0;
		boolean yearOdd = !yearEven;
		boolean birthEven = birth % 2 == 0;
		boolean birthOdd = !birthEven;
		
		
	    //boolean result = over30 && (나머지 조건들);
		//boolean result = 30세이상 && ((짝수년도생 + 짝수년도)) || (홀수년도생 + 홀수년도));
		boolean result = over30 && ((birthEven && yearEven) || (birthOdd && yearOdd));
		System.out.println(result);
		
	}

}

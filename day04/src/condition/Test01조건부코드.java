package condition;

public class Test01조건부코드 {
	public static void main(String[] args) {
		//논리의 확장편 : 조건부코드
		
		//입력
		
		
		//처리
		int number = 7;
		boolean odd = number % 2 != 0;
		boolean even = number % 2 == 0;
		
		
		//출력
		
			if(odd == true) { //odd가 true면 실행되는 블럭
			System.out.println("홀수");
		}
		
		if(even == true) { //even이 true면 실행되는 블럭
		System.out.println("짝수");
		}
	}

}

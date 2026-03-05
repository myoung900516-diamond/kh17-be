package loop;

public class Test01반복되는코드 {
	public static void main(String[] args) {
		//(Q) "안녕하세요"를 10번 출력
		//-for 구문을 이용해서 10번이라는 횟수를 지정
		//for(10번)
		
		//for (선언부 ; 조건부; 증감부)
		for(int i = 1 ; i <= 10; i = i + 1){
		//System.out.println("안녕하세요");
			System.out.println("안녕하세요" + i);
		}
		/*System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		*/
		for(int i = 1 ; i <=5 ; i = i +1) {
			//System.out.println("Hello");
			System.out.println("Hello" + i);
		}
	}

}

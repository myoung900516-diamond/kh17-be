package api.exception;

import java.util.Scanner;

public class Test01예외처리가필요한이유 {
	public static void main(String[] args) {
		//(ex)N분의1계산기
		
		Scanner sc = new Scanner(System.in);
		System.out.println("금액 : ");
		int money = sc.nextInt();
		System.out.println("인원 : ");
		int people = sc.nextInt();
		
		int price = money / people;
		int remain = money % people;
		
		System.out.println("한 명당 " + price + "원 씩 이체하시면 됩니다.");
		System.out.println("자투리금액 : " + remain + "원");
		
		//잘못입력했을 때 처리하는 방법 
		//에러의 종류 수 
		//-금액을 문자로 = 금액 : 
//		오만원
//		Exception in thread "main" java.util.InputMismatchException //헤드라인
//			at java.base/java.util.Scanner.throwFor(Scanner.java:947) //스택트레이스(오류추적결과)
//			at java.base/java.util.Scanner.next(Scanner.java:1602) //스택트레이스(오류추적결과)
//			at java.base/java.util.Scanner.nextInt(Scanner.java:2267) //스택트레이스(오류추적결과)
//			at java.base/java.util.Scanner.nextInt(Scanner.java:2221) //스택트레이스(오류추적결과)
//			at api.exception.Test01예외처리가필요한이유.main(Test01예외처리가필요한이유.java:11) //스택트레이스(오류추적결과)
		
		//-금액이 너무 큰 경우
//		금액 : 
//			5000000000000300002020303040000000000040303020202000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
//			Exception in thread "main" java.util.InputMismatchException: For input string: "5000000000000300002020303040000000000040303020202000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
//				at java.base/java.util.Scanner.nextInt(Scanner.java:2273)
//				at java.base/java.util.Scanner.nextInt(Scanner.java:2221)
//				at api.exception.Test01예외처리가필요한이유.main(Test01예외처리가필요한이유.java:11)
	
		//인원을 문자로 
//		금액 : 
//			50000
//			인원 : 
//			다섯명
//			Exception in thread "main" java.util.InputMismatchException
//				at java.base/java.util.Scanner.throwFor(Scanner.java:947)
//				at java.base/java.util.Scanner.next(Scanner.java:1602)
//				at java.base/java.util.Scanner.nextInt(Scanner.java:2267)
//				at java.base/java.util.Scanner.nextInt(Scanner.java:2221)
//				at api.exception.Test01예외처리가필요한이유.main(Test01예외처리가필요한이유.java:13)


		//인원이 너무 많을 때 
//		금액 : 
//			50000
//			인원 : 
//			23450000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
//			Exception in thread "main" java.util.InputMismatchException: For input string: "23450000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
//				at java.base/java.util.Scanner.nextInt(Scanner.java:2273)
//				at java.base/java.util.Scanner.nextInt(Scanner.java:2221)
//				at api.exception.Test01예외처리가필요한이유.main(Test01예외처리가필요한이유.java:13)
//
		
		//금액을 소수점으로 
//		금액 : 
//			7000.9
//			Exception in thread "main" java.util.InputMismatchException
//				at java.base/java.util.Scanner.throwFor(Scanner.java:947)
//				at java.base/java.util.Scanner.next(Scanner.java:1602)
//				at java.base/java.util.Scanner.nextInt(Scanner.java:2267)
//				at java.base/java.util.Scanner.nextInt(Scanner.java:2221)
//				at api.exception.Test01예외처리가필요한이유.main(Test01예외처리가필요한이유.java:11)

//		금액 : 
//			456
//			인원 : 
//			0
//			Exception in thread "main" java.lang.ArithmeticException: / by zero
//				at api.exception.Test01예외처리가필요한이유.main(Test01예외처리가필요한이유.java:15)

	}

}

package api.string3;

public class Test01문자열합성4 {
	public static void main(String[] args) {
		//문자열 합성과 문제점 
		//가변 문자열 역할을 하는 StringBuffer와 StringBuilder를 쓰면 성능이 좋다/ 
		//(ex)별을 10개 만들어보세요.
		StringBuilder star = new StringBuilder();
		long begin =System.currentTimeMillis();
		for(int i = 1; i<= 1000000000; i++) {
			star.append("*");
		}
		//이 반복문이 걸리는 시간 =별이 만들어지는데 걸리는 시간 
		long end = System.currentTimeMillis();
		System.out.println("소요시간 " + (end - begin) + "ms"); //1ms= 1/1000s
		
		//thread-safe = 여러 도구들을 한꺼번에 사용할 때 질서를 잡아줌
		//StringBuffer는 thread-safe지만 StringBuilder는 nonThread-safe이다. 
		//장단점이 있다. 도구들이 여러개면 thread-safe, 도구들이 한 두개면 nonthread-safe
		
	}

}

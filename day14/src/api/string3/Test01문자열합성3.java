package api.string3;

public class Test01문자열합성3 {
	public static void main(String[] args) {
		//문자열 합성과 문제점 
		//가변 문자열 역할을 하는 StringBuffer와 StringBuilder를 쓰면 성능이 좋다/ 
		//(ex)별을 10개 만들어보세요.
		StringBuffer star = new StringBuffer();
		long begin =System.currentTimeMillis();
		for(int i = 1; i<= 1000000000; i++) {
			star.append("*");
		}
		//이 반복문이 걸리는 시간 =별이 만들어지는데 걸리는 시간 
		long end = System.currentTimeMillis();
		System.out.println("소요시간 " + (end - begin) + "ms"); //1ms= 1/1000s
		
		
		
	}

}

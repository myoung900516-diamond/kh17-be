package api.string3;

public class Test01문자열합성2 {
	public static void main(String[] args) {
		//문자열 합성과 문제점 
		//(ex)별을 10개 만들어보세요.
		//String star = "**********";
		String star = "";
		long begin =System.currentTimeMillis();
		for(int i = 1; i<= 100; i++) {
		star += "*";
		}
		//이 반복문이 걸리는 시간 =별이 만들어지는데 걸리는 시간 
		long end = System.currentTimeMillis();
		System.out.println("소요시간 " + (end - begin) + "ms"); //1ms= 1/1000s
		
		
		//문자열은 불변(immutable)이기 때문에 단순하게 연결만 해도 새로운 문자열이 생김
		//한두개는 괜찮은데, 많아지면 주의해야함 
		
		//데이터가 적은게 좋은가 아니면 원하는 기능을 실현하는 것이 좋은가 
		//데이터가 적을 수록 성능이 좋아지는가? 
		//System.out.println(star);
		
		
	}

}

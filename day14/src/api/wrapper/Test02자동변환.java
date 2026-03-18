package api.wrapper;

public class Test02자동변환 {
	public static void main(String[] args) {
		//int와 Integer는 자동변환이 가능
		//작은 범위(-128~127)사이만 동일하고 나머진 새로 생성
		Integer a = 10; //int →Integer 자동변환(auto-boxing), 
		Integer b = 10;
		Integer c = new Integer(10);
		Integer d = new Integer(10);
		
		Integer e = Integer.valueOf(10);
		Integer f = Integer.valueOf(10);
		System.out.println(a == e);
		System.out.println(e == f);
		
		//반대는 auto-unboxing이라고 부름(Integer → int)
		int g = a;
		
		//(암기)Integer와 int를 구분해야만 하는 상황 (암기)
		
	}

}

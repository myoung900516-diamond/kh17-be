package api.wrapper;

public class Test01하이브리드클래스2 {
	public static void main(String[] args) {
		//Wrapper class
		//-원시형 데이터(primitive type)를 클래스로 만들어논 형태
		//-Wrap 단어는 감싸다 라는 의미 
		//-원시형 데이터를 편하게 이용할 수 있도록 객체화 시켜둔 클래스 
		//-계산이 간단할 수록 원시형이 유리하며 계산이 복잡할수록 참조형이 유리 
		
		//간단한 계산 : 10더하기 20
//		Integer a = new Integer(10);
//		Integer b = new Integer(20);
//		Integer c = new Integer(a + b);
		
		Integer a = Integer.valueOf(10);
		Integer b = Integer.valueOf(20);
		Integer c = Integer.sum(a, b);
		System.out.println("c =" + c);
		
		
	}

}

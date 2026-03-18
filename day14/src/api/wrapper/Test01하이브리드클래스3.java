package api.wrapper;

public class Test01하이브리드클래스3 {
	public static void main(String[] args) {
		//Wrapper class
		//-원시형 데이터(primitive type)를 클래스로 만들어논 형태
		//-Wrap 단어는 감싸다 라는 의미 
		//-원시형 데이터를 편하게 이용할 수 있도록 객체화 시켜둔 클래스 
		//-계산이 간단할 수록 원시형이 유리하며 계산이 복잡할수록 참조형이 유리 
		
		//복잡한 계산 : 2진수 변환
		int number = 157;
		
		StringBuffer buffer = new StringBuffer();
		for(int i=number; i>0; i /=2) {
			buffer.insert(0, i % 2);
		}
		System.out.println(buffer.toString());
		System.out.println("10011101");
		System.out.println(Integer.toBinaryString(number));
		
	}

}

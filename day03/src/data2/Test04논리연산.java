package data2;

public class Test04논리연산 {
	public static void main(String[] args) {
		//논리 하나만으로 문언가 판단하기에는 부족한 경우가 많다.
		//-(예) 청소년? 14세 이상 and 19세 이하 
		//윤년? 무임승차대상?
		
		int age = 5;
		//boolean teen = 14 <= age <= 19; :현실에서 쓰는 방식(특정구간)
		boolean teen = 14 <= age && age <= 19; //자바의 방식(AND연산)
		System.out.println(teen);
		
		//-(예) 무임승차? 7세 이하 or 65세 이상
		boolean free = age >= 65 || age <= 7;
		System.out.println(free);
		
		//정리하면
		//-논리는 and(&&)와 or(||)로 연결할 수 있다. 
		//-다양한 상황들을 고려해서 하나의 판단을 만들어낼 수 있다. 
		
		
		
	}

}

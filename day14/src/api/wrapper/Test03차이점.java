package api.wrapper;

public class Test03차이점 {
	public static void main(String[] args) {
		//int와 Integer를 반드시 구분해야 하는 상황이 존재 
		//-null이 발생할 수 있는 경우 
		
		Integer a = null;
		//int b = null; 불가능한 값 
		//계산한 값에 null이 들어갈 수 있으면 반드시 구분해서 사용해야 함 
		int b = a;//문법적으로는 문제가 없는데 실행하면 오류가 나는 코그(런타임에러)
		System.out.println("b= " + b);
		
	}

}

package data2;

public class Test06숫자탐색기 {
	public static void main(String[] args){
		
		
		//입력
		int number = 57;
		
		
		
		//처리
		int ten = number / 10; //number의 10의 자리;
		int one = number % 10; //number의 1의 자리;
		System.out.println(ten);
		System.out.println(one);
		
		boolean seven = ten == 7 || one == 7;
		//boolean seven = number / 10 == 7 || number % 10 == 7;
		
		
		//출력
		System.out.println(seven);
		
	}
	

}

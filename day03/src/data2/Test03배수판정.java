package data2;

public class Test03배수판정 {
	public static void main(String[] args) {
		
	//배수판정?
	//- 2의배수(짝수), 3의배수, 4의배수, ...
	
	int number = 6;
	
	//boolean two = number를 2로 나눈 나머지가 0인가요?;
	boolean two = number % 2 == 0;
	System.out.println(two);
	
	boolean three = number % 3 == 0;//3의 배수 판정식
	System.out.println(three);
	
	boolean four = number % 4 == 0;
	System.out.println(four);
	
	
	//추가 : 홀수판정
	//boolean odd = number % 2!=0; //2로 나눈 나머지가 0이 아니면 홀수!
	//boolean odd = number % 2 == 1; //2로 나눈 나머지가 1이면 홀수!
	boolean odd = !two; //two가 true인 경우의 반대면 홀수!(느낌표가 앞에 붙어면 반대, 부정의 의미)
	System.out.println(odd);
	
	
	}
	

}

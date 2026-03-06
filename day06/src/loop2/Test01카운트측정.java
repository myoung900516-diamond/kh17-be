package loop2;

public class Test01카운트측정 {
	public static void main(String[] args) {
		//카운트 
		//- (Q) 1부터 10사이의 홀수 개수를 구하세요.
		//1.1부터 10사이의 홀수를 출력하는 반복문을 작성
		//2. 카운트 측정을 위한 변수를 생성하고 0으로 초기화
		//3. 원하는 지점에 카운트 증가 코드를 작성
		//4. 작업이 끝나고 타운트를 출력하여 확인
		
		//처리
		int count = 0;
		
		for (int i = 1 ; i <=10 ; i++) {
			if( i % 2 != 0 ) {
				//System.out.println(i);
				count++;
			}
		}
		System.out.println("count = " + count);
	}

}

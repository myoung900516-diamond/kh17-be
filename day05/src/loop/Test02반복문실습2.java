package loop;

public class Test02반복문실습2 {
	public static void main (String[] args) {
	
		//1. '1'부터 '100'까지의 정수
		//-> 1부터 100이하일 동안 씩 증가하며 코드를 실행
		//for(int i = 1; i<= 100; i = i+1){//대입연산
		//for(int i = 1; i <= 100 ; i += 1 ) {//복합대입연산(더해넣어라)
		for(int i = 1 ; i <= 100 ; i++) {//증감연산 (1증가 혹은 감소)
			System.out.println("1번문제 = " + i);
		}
		
		//2.소문자 알파벳
		//-> (아스키코드표를 확인해본뒤) 97부터 122까지 1씩 증가하며 
		//for(int i =97 ; i <= 122 ; i++){
		for(char i = 'a' ; i <= 'z' ; i++) {
			System.out.println("2번문제 = " + i);
		}
		for(char i = '가' ; i <= '힣' ; i++) {
			System.out.println(i);
		}
		//3. '1'부터 '100'까지의짝수
		//-> 2, 4, 6, 8, 10, ... ,92, 94, 96, 98, 100
		//-> 2부터 100까지 2씩 증가
		//->효율적이지만 권장하지 않음
		//for(int i = 2 ; i<= 100 ; i +=2) {
			//System.out.println("3번문제 = " + i);
		//}
		//->비효율적이지만 표준화가 가능한 형태 
		for(int i = 1 ; i <= 100 ; i++) { //1부터 100까지 1씩 증가
			if(i % 2 == 0 ) {  //i가 짝수라면
				System.out.println("3번문제 = " + i);
			}
		}
		//4. '1'부터 '100'까지의 3의 배수
		//-> 3, 6, 9, 12, 15, ..., 90, 93, 96, 99(3부터 99까지 3씩 증가)
		//for(int i = 3 ; i <= 99; i +=3) {
			//System.out.println("4번문제 = " + i);
		//}
		for(int i = 1 ; i <= 100 ; i++) { //1부터 100까지 1씩 증가
			if(i % 3 == 0) { //i가 3의 배수라면 
				System.out.println("4번문제 = " + i);
			}
		}
	}

}

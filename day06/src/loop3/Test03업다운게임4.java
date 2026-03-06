package loop3;

import java.util.Random;
import java.util.Scanner;

public class Test03업다운게임4 {
	public static void main(String[] args) {
		//탈출조건
		//개발할 때는 답을 보면서 해야 잘잘못을 알 수 있다. 
			//-정답 생성(1부터 1000까지 = 1부터 1000개)
			Random r = new Random();
			int answer = r.nextInt(1000) + 1;
			System.out.println("answer = " + answer);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
			//-사용자입력
			System.out.print("정답입력 : ");
			int user = sc.nextInt();
			
			if(answer > user) { 
				System.out.println("업");
			}
			else if(answer < user) { 
				System.out.println("다운");
			}
			else {
				System.out.println("정답");
				break;
			}
			
		}
		
		
	}

}

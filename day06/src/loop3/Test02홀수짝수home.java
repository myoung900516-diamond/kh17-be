package loop3;

import java.util.Scanner;

public class Test02홀수짝수home {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int countEven = 0;
		int countOdd = 0;
		
		while(true) {
			int a = sc.nextInt();
			
		if( a % 2 == 0 && a != 0) {
			countEven +=1;
		}
		else if ( a % 2 == 1) {
			countOdd +=1;
		}
		else { break;
		}
		}
		System.out.println("짝수 개수는 " + countEven + "개, 홀수 개수는 " + countOdd + "개 입니다");
	}

}

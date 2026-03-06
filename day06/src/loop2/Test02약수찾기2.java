package loop2;

import java.util.Scanner;

public class Test02약수찾기2 {
	public static void main (String[] args) {
		
	//6의 약수가 몇개에요? 
	//→ 6을 1부터 6까지 숫자로 나눈 나머지를 확인해본다
		int number = 6;
		int count = 0;
		for(long i = 2 ; i<= number ; i++) {
			if (number % i ==0) {
				System.out.println("약수 : " +i );
				count++;
				break;
				}
			}
			//System.out.println(number + "%" + i + " = " + number % i); //출력
		}
		
		//System.out.println("약수 개수 = " + count);
		//소수 : 나눗셈이 안되는 정수를 의미(2, 3, 5, 7, ...)
		//if(count > 0) {
			//System.out.println("소수가 아닙니다");
		//}
		//else { 
			//System.out.println("소수입니다");
			
		//}
	}

//}

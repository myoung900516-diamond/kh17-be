package array;

import java.util.Scanner;

public class Teat09배열뒤집기7 {
	public static void main(String [] args) {
		
		//배열 준비 
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//데이터교체
	
		int left = 0;
		int right = data.length - 1; //4;
		for(int i = 0; i < data.length/2; i++) {
			System.out.println("[" + left + "] , [" + right + "]" );
			left++;
			right--;
		}
		//*모듈화*
		
		
		//출력
		//-출력을 반대로 하는건 데이터가 뒤집힌 것이 아니다.이렇게 풀면 다음이 안 된다. 
//		for(int i = 4; i >= 0; i--){
//			System.out.print(data[i] + "\t"); //\t:탭키
//		}
		
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\t"); //\t:탭키
		}
		
		 
		}
	}



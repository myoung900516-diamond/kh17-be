package array;

import java.util.Scanner;

public class Test07배열회전home2 {
	public static void main(String[] args) {
		
		int[] data = new int[] {30, 20, 10, 50, 40};
	//	int round = 1;
		
		//회전
		Scanner sc = new Scanner(System.in);
		System.out.print("회전할 횟수 : " );
		int size = sc.nextInt();
		
		for(int i = 0; i < size; i++) {
		int backup = data[4];
		data[4] = data[3];
		data[3] = data[2];
		data[2] = data[1];
		data[1] =  data[0];
		data[0] = backup;
		}
		
		//data[data.length] = 
		
		//출력
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

}

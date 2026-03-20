package api.util.etc;

import java.util.Scanner;

public class Test03스캐너의문제점2 {
	public static void main(String[] args) {
		//단어 입력하면 그다음 입력이 안됨 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단어: ");
		String word = sc.next();
		
		//(중요) next()계열의 명령 이후에 nextLine()이 나오면 정리작업을 무조건 한 번 해줘야 한다. 
		sc.nextLine();
		
		System.out.print("한줄 : ");
		String line = sc.nextLine();
		
		System.out.println("word =" + word);
		System.out.println("line = " + line);
		
		sc.close();//열려있는 통로(stream)을 닫는 명령//이거 쓰는 습관 들이자 
		
		
	}

}

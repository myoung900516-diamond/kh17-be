package api.util.etc;

import java.util.Scanner;

public class Test03스캐너의문제점 {
	public static void main(String[] args) {
		//단어 입력하면 그다음 입력이 안됨 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단어: ");
		String word = sc.next();//next()는 처음에 정리를 하고 입력만 받고 따로 정리를 안한다. (지저분한 사람)
		
		System.out.print("한줄 : ");
		String line = sc.nextLine();//nextLine()은 \n으로만 구분하기 때문에 정리를 하고 나온다. (깔끔한 사람) 처음에 정리를 안하고 입력 받고 \n을 버림 
		
		System.out.println("word =" + word);
		System.out.println("line = " + line);
		
		sc.close();//열려있는 통로(stream)을 닫는 명령//이거 쓰는 습관 들이자 
		
		
	}

}

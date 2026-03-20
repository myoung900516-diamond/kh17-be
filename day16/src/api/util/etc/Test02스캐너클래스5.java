package api.util.etc;

import java.util.Scanner;

public class Test02스캐너클래스5 {
	public static void main(String[] args) {
		//Scanner클래스
		//-문자열, 입력통로, 파일 등 글자가 존재하는 대상을 읽어서 분석할 수 있는 도구
		
		String sample = "동해물과 백두산이 마르고 닳도록 \n하느님이 보우하사 우리나라만세";
		
		Scanner sc = new Scanner(sample);//sample문자열을 분석하는 Scanner를 만드세요!
		
		
		
		while(sc.hasNextLine() == true) {
		
		String word = sc.nextLine();//한 줄을 읽는 명령(\n만으로 구분)
		System.out.println(word);
		
		}
		
		//(중요) stream은 사용 종료 후 자원 낭비를 막기 위해 종료(해제)해야 한다.
		sc.close();
		
	}

}

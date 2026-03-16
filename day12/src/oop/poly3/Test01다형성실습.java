package oop.poly3;

import java.util.Scanner;

public class Test01다형성실습 {
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		System.out.println("노트북을 선택 하세요.");
		System.out.println("1. 맥북     2. 갤럭시북     :");
		int choice = sc.nextInt();
		
		
		System.out.println("테스트할 기능을 선택하세요");
		System.out.println("1. 전원    2. 동영상재생     3.타이핑  :");
		int choice2 = sc.nextInt();
		
		
		if( choice == 1) {
			//System.out.println("맥북 기능 실행");
			if(choice2 == 1) {
				System.out.println("맥북으로 전원기능을 실행합니다");
			}
			if(choice2 == 2) {
				System.out.println("맥북으로 동영상을 재생합니다");
			}
			else {
				System.out.println("맥북으로 타이핑기능을 실행합니다");
			}
		}
		if( choice == 2) {
			//System.out.println("맥북 기능 실행");
			if(choice2 == 1) {
				System.out.println("갤럭시북으로 전원기능을 실행합니다");
			}
			if(choice2 == 2) {
				System.out.println("갤럭시북으로 동영상을 재생합니다");
			}
			else {
				System.out.println("갤럭시북으로 타이핑기능을 실행합니다");
			}
		}
		
//		MacBook m = new MacBook();
//		m.power();
//		m.video();
//		m.typing();
//		
//		
//		GalaxyBook g = new GalaxyBook();
//		g.power();
//		g.video();
//		g.typing();
//		
		
	}

}

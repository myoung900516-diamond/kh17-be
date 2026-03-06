package loop3;

import java.util.Scanner;

public class Test04베스킨라빈스31설명 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = 1;
		while(true) {
			System.out.println("개수 입력(1~3) : ");
			int user = sc.nextInt();
			
			System.out.println("숫자를" + user + "개 선택하셨습니다");
			
			number +=user;
			
			if(number >31 ) break;
			
	
		}	
	System.out.println("게임 오버");

}
}

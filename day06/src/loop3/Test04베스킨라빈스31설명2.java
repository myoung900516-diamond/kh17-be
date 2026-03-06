package loop3;

import java.util.Scanner;

public class Test04베스킨라빈스31설명2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = 1;
		
		while(true) {
			System.out.println("개수 입력(1~3) : ");
			int user = sc.nextInt();
			
			if(user <1)continue;
			if(user > 3)continue;
			
			//System.out.println("숫자를" + user + "개 선택하셨습니다");
			//1,2,3선택!
			//범위 : number부터 number + user까지 
			
			for(int i = number; i < number + user; i++); {
		//		System.out.print(i);
			}
			number +=user;
			
			if(number >31 ) break;
			
	
		}	
	System.out.println("게임 오버");

}
}

package loop3;

import java.util.Scanner;

public class Test04베스킨라빈스31home {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("베스킨 라빈스 31~, 1~3사이의 숫자를 입력하세요.");
		
		int count = 0;
		
		while(true) { 
			
			int user = sc.nextInt(); 
			
			if ( user > 3 || user < 1) {
				System.out.println("숫자는 1~3사이의 숫자로 입력해주세요");
			}
			if (user == 1) { 
				count += 1;
				System.out.println("현재 위치 : " + count);
			}
			else if (user == 2) {
				count += 2;
				System.out.println("현재 위치 : " + count);
			}
			else if (user == 3 ) {
				count +=3;
				System.out.println("현재 위치 : " + count);
			}
			
		     if (count >31 ) {
			//System.out.println("현재 위치 : " + 31);
			break;
			}
			
		}
		System.out.println("게임 오버");
	}

}

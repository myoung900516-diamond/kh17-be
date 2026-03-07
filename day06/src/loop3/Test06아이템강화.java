package loop3;

import java.util.Random;

public class Test06아이템강화 {
	public static void main(String[] args) {
		
		Random r = new Random();
		System.out.println("1레벨 아이템을 10레벨까지 강화합니다");
		
		int level = 1;
		int count = 0;
		int success = 0;
		int keep = 0;
		int fail = 0;
		
		
		while(true) {
			
			int answer = r.nextInt(3) + 1;
			count ++;
			
			if ( answer == 1) {
				level += 1;
				System.out.println(count + "회차 - 성공(+1), 현재 레벨 : " + level );
				success ++;
			}
			if (answer == 2) {
				level = level;
				System.out.println(count + "회차 - 유지, 현재 레벨 : " + level );
				keep ++;
			}
			if ( answer == 3 ) {
				level -=1;
				System.out.println(count + "회차 - 실패(-1), 현재 레벨 : " + level );
				fail ++;
			}
			
			if(level == 10) {
				//int total = success + keep + fail;
				int successPerAll = success*100/count;
				int keepPerAll = keep*100/count;
				int failPerAll = fail*100/count; 
				System.out.println("★★★강화가 완료되었습니다★★★");
			    System.out.println("- 성공 횟수 " + success + "번 (" + successPerAll + "%)");
			    System.out.println("- 실패 횟수 " + fail + "번 (" + failPerAll + "%)");
			    System.out.println("- 유지 횟수 " + keep + "번 (" + keepPerAll + "%)");
			    break;
			}
		}
		
	}

}

package loop3;
 /*
이 과제는 코드만 제공하고 별도의 풀이는 하지 않습니다.
제출하지 않으셔도 상관 없습니다. (제출하시면 검토합니다)

어떤 게임의 아이템 강화 확률은 다음과 같습니다.

성공 확률 : 20% , 아이템의 레벨이 1 증가합니다.
유지 확률 : 60% , 아이템의 레벨이 그대로 유지됩니다
실패 확률 : 20% , 아이템의 레벨이 1 감소합니다
아이템의 레벨은 1부터 10 사이로만 설정이 가능합니다

레벨 1인 아이템을 이 규칙대로 10까지 강화하는 시뮬레이션을 구현하세요

실행 예시
1레벨 아이템을 10레벨까지 강화합니다
1회차 : 성공(+1), 현재 레벨 2
2회차 : 실패(-1), 현재 레벨 1
3회차 : 실패(-1), 현재 레벨 1
4회차 : 유지, 현재 레벨 1
5회차 : 성공(+1), 현재 레벨 2
6회차 : 성공(+1), 현재 레벨 3
7회차 : 성공(+1), 현재 레벨 4
8회차 : 실패(-1), 현재 레벨 3
9회차 : 유지, 현재 레벨 3
...(중간생략)...
80회차 : 성공(+1), 현재 레벨 9
81회차 : 성공(+1), 현재 레벨 10
★★★ 강화가 완료되었습니다 ★★★
- 성공 횟수 35번 (43%) ← 정수로 출력
- 실패 횟수 26번 (32%) ← 정수로 출력
- 유지 횟수 20번 (24%) ← 정수로 출력
*/
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

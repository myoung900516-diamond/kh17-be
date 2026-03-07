package loop3;

import java.util.Random;

public class Test06아이템강화2 {
    public static void main(String[] args) {

        Random r = new Random();

        int level = 1;
        int count = 0;
        int success = 0;
        int keep = 0;
        int fail = 0;

        System.out.println("강화 시작! 현재 레벨 : " + level);

        while(level < 10) {

            count++;

            int num = r.nextInt(100); // 0~99 랜덤

            if(num < 20) { // 성공 20%
                level++;
                if(level > 10) {
                    level = 10;
                }
                success ++;
                System.out.println(count + "번째 강화 : 성공 → 레벨 " + level);
            }

            else if(num < 80) { // 유지 60%
            	keep ++;
                System.out.println(count + "번째 강화 : 유지 → 레벨 " + level);
            }

            else { // 실패 20%
                level--;
                fail ++;
                if(level < 1) {
                    level = 1;
                }
                System.out.println(count + "번째 강화 : 실패 → 레벨 " + level);
            }
        }

        System.out.println("레벨 10 달성! 총 시도 횟수 : " + count);
        System.out.println("- 성공 횟수 " + success + "번 ( " + success*100/count + "% )");
	    System.out.println("- 실패 횟수 " + fail + "번 (" + fail*100/count + "% )");
	    System.out.println("- 유지 횟수 " + keep + "번 (" + keep*100/count + "% )");
    }
}
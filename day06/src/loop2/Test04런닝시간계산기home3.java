package loop2;

public class Test04런닝시간계산기home3 {
	public static void main(String[] args) {
	
		int day = 1;
		//int round = 1;
		int count = 0;
		int time = 20;
		int total = 0;
		
		for( day = 1; day <= 7 * 4; day ++) {
			if(day % 2 == 1) {
			count ++;
			System.out.println(day + "일, " + count + "회차 - " + time + "분" );
			total += time;
			System.out.println("총 누적 시간은 " + total + " 분 입니다.");
			}
		
		     if (day % 7 == 0) {
			time += 5; 
			
		}
			}
		}
			}
		
	


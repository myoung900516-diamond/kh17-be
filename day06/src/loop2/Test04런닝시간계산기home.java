package loop2;

public class Test04런닝시간계산기home {
	public static void main(String[] args) {
		
		int count = 0;
		int minute = 20;
		//int more = 5;
		int total = 0;
		
		for(int day = 1; day <=28; day ++) {
//			if(day % 7 ==1) {
//				minute += 5;
//				System.out.println(day + "일 - " + minute + "분");
//			}
			if(day % 2 == 1 ) {
				count ++;
				if(day > 7 && day < 14) {
					minute = 25;
				}
				else if (day >14 && day <21) {
					minute = 30;
				}
				else if (day > 21 && day < 28) {
					minute = 35;
				}
				total += minute;
				int hour = total/60;
				int min = total%60;
				System.out.println(count + "회차 ( "+ day + "일) - " + minute + "분");
				System.out.println("누적시간은 " + total + "분 입니다");
				System.out.println("누적시간은" + hour + "시간 " + min + "분 입니다");
			}
		}
		
		
		//System.out.println("1회차(1일) - ?분");
	}
	
}

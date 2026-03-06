package loop2;

public class Test04런닝시간계산기4 {
	public static void main(String[]args) {
		
		int round = 1; //회차
		int time = 20; //시간
		
		
		for(int day = 1 ; day <= 7*4 ; day++) {
			if(day % 2 ==1) {//홀수일 = 내가 뛰는 날
				System.out.println(day + "일(" + round + "회차) -" + time +  "분");
				round++;
			}
			//else {
			//	System.out.println(day + "일 - 휴식");
			//}
			
			//7일마다 5분씩 증가 
			if(day % 7 == 0) {//일주일이 되면 
				time +=5;
			}
		}
		
		
	}

}

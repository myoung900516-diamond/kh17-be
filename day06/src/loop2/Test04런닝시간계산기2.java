package loop2;

public class Test04런닝시간계산기2 {
	public static void main(String[]args) {
		
		int total = 0;
		int day = 1;
		int week = 1;
		
		
		for(day = 1 ; day <= 28; day ++) {
			if(day % 2 == 0) {
				total = 0;
				System.out.println(day + "회 (" + day + "일차)  -  " + total + "분");
			}
			if ( day % 2 != 0 ) {
				total = 20;
				System.out.println(day + "회 (" + day + "일차)  -  " + total + "분");
				
			}
			
		}
		
	}

}

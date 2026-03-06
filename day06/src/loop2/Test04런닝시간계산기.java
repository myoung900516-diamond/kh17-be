package loop2;

public class Test04런닝시간계산기 {
	public static void main(String[]args) {
		int total = 0; 
		int week = 1;
		for(int i = 20; i <= 35; i = i + 5) {
			if(i % 2 !=0) {	
				total += total;
				System.out.println("누적시간은 " + total + "분 입니다");
				week +=1;
			}
			
		}
		
	}

}

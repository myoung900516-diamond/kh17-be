package loop;

public class Test03숫자찾기2 {
	public static void main(String[] args) {
		
		/*
		//1.최대한 규칙을 찾아서 반복문 만으로 해결
		//-구간1 : 5,15,25,35,45
		//-구간2 : 50, 51, 52, 53, 54, 55, 56, 57, 58, 59 (50부터 59까지 1씩 증가)
		//-구간3 : 65, 75, 85, 95 (65부터 95까지 10씩 증가)
		for(int i = 5 ; i <= 45 ; i += 10) {
			System.out.println("5가 들어간 숫자 = " + i);
		}
		for(int i = 50 ; i <= 59 ; i++) {
			System.out.println("5가 들어간 숫자 = " + i);
			*/
		
		
		
		//2.주어진 범위에서 조건을 걸어 필터링
		for(int i = 1 ; i <= 100 ; i++) {
			//if(5가 포함되어 있다면) {
			//if(i/ 10 == 5 || i % 10 == 5) //한줄로 쓴다면 
			boolean ten = i / 10 == 5;
			boolean one = i % 10 == 5;
			boolean five = ten || one;
			if(five) {
				System.out.println("5가 들어간 숫자 = " + i);

			}
			
		
				
			}
		}
		
		
	}
		
	



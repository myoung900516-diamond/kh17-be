package loop;

public class Test03숫자찾기 {
	public static void main(String[] args) {
		//for(int i = 5 ; i <= 1000 ; i += 10) {
		//	System.out.println(i);
			
		//}
		
		for(int i = 1 ; i <= 100 ; i = i + 1 ) {
			if(i/10 == 5 || i % 10 == 5 ) {
				System.out.println(i);
			}
//			System.out.println(i);
			
		}
		
	}

}

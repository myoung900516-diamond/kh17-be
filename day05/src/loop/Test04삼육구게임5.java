package loop;

public class Test04삼육구게임5 {
	public static void main(String[] args) {
		
		for(int i = 1; i <=99; i = i + 1) {
			boolean three = i / 10 == 3 || i % 10 == 3;
			boolean six = i / 10 == 6 || i % 10 == 6;
			boolean nine = i / 10 == 9 || i % 10 == 9;
			boolean match = three||six||nine;
			
			if(match) {
				System.out.println("짝");
			}
			else {
				System.out.println(i);
			}
		}
	}
}

	



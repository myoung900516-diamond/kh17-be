package loop;

public class Test04삼육구게임6 {
	public static void main(String[] args) {
		
		for(int i = 1; i <=99; i = i + 1) {
		boolean ten = i / 10 == 3 || i / 10 == 6 || i / 10 == 9;
		boolean one = i % 10 == 3 || i % 10 == 6 || i % 10 == 9;
		
		if(ten && one) {
			System.out.println("짝짝");
			}
		else if (ten || one ) {
			System.out.println("짝");
		}
		else {
			System.out.println(i);
		}
		}
	}
}

	



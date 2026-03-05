package loop;

public class Test04삼육구게임4 {
	public static void main(String[] args) {
		
			//범위 내에서 3,6,9가 포함된 숫자를 찾아서 출력
		for(int i = 1 ; i <= 99 ; i = i + 1) {
			//if(3,6,9가 들어있다면){
			boolean ten = i /10 == 3 || i / 10 == 6 || i / 10 == 9;
			boolean one = i % 10 == 3 || i % 10 == 6 || i % 10 == 9; 
		
			if(ten && one) {//if 문에서 까다로운게 가장 먼저 와야함
				System.out.println("짝짝");
				
			}
			else if (ten || one) {
				System.out.println("짝");
			}
			else {
				System.out.println(i);
			}
		}
	}
}

	



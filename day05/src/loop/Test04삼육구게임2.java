package loop;

public class Test04삼육구게임2 {
	public static void main(String[] args) {
		
			//범위 내에서 3,6,9가 포함된 숫자를 찾아서 출력
		for(int i = 1 ; i <= 99 ; i = i + 1) {
			//if(3,6,9가 들어있다면){
			boolean three = i / 10 == 3 || i % 10 ==3;
			boolean six = i / 10 == 6 || i % 10 == 6;
			boolean nine = i/10 == 9 || i % 10 == 9;
			if(three || six|| nine) {
				System.out.println(i);
			}
		}
	}
}

	



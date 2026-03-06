package loop2;

public class Test02약수찾기home {
	public static void main(String[] args) {
		
		
		//입력
		
		int a = 556;
		int count = 0;
		
		System.out.print(a + "의 약수 : ");
		
		for(int i = 1 ; i <= a  ; i ++) {
			if(a % i == 0) {
				if(i != a) {
				System.out.print(i + ", ");
				}
				else {
					System.out.print(i);
				}
				count ++;
		
			}
		}
		System.out.println(" ");
		System.out.println( a + "의 약수의 개수 : " + count + "개");
			}

}

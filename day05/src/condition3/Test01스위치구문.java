package condition3;

public class Test01스위치구문 {
	public static void main(String[] args) {
		//switch 구문 
		//-조건부 코드를 실행 할 수 있는 if와 다른 실행원리를 가진 구문 
		
		int keycode = 'a';
		
		if(keycode == 'w') {
			System.out.println("앞으로 이동");
		}
		else if (keycode == 'a') {
			System.out.println("왼쪽으로 이동");
		
		}
		else if(keycode == 's') {
			System.out.println("뒤로 이동");
		}
		else if ( keycode == 'd') {
			System.out.println("오른쪽으로 이동");
		}
		else {
			System.out.println("지원하지 않은 키");
		}
	}
	

}

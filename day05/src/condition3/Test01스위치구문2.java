package condition3;

public class Test01스위치구문2 {
	public static void main(String[] args) {
		//switch 구문 
		//-조건부 코드를 실행 할 수 있는 if와 다른 실행원리를 가진 구문 
		//순차적 실행이 아니라 동시실행이 가능하도록 설계된 구문
		int keycode = 'a'; //문자니까 ''를 씀.
		
		switch(keycode) {//keycode의 값을 가지고 이동할 지점을 한번에 찾겠다.!
		case 'w': //keycode가 'w'면 여기서부터 시작해!
			System.out.println("앞으로 이동");
			break; //그만 하고 나가라!
		case 'a'://keycode가 'a'면 여기서부터 시작해!
			System.out.println("왼쪽으로 이동");
			break;
		case 's':
			System.out.println("뒤로 이동");
			break;
		case 'd':
			System.out.println("오른쪽으로 이동");
			break;
		default: //case에 해당하는 것이 없다면 기본 실행되는 위치(else 역할)
		System.out.println("지원하지 않는 키");
		break; //break 생략 가능
		}
		//switch문의 단점 : 범위가 안되요. 

		
	}
	

}

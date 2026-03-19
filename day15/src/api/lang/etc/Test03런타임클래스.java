package api.lang.etc;

import java.io.IOException;

public class Test03런타임클래스 {
	public static void main(String[] args) {
		//Runtime클래스
		//-생성이 잠겨있고 생성명령이 존재하는 클래스
		//-static 메소드 중에 반드시 생성:메소드가 존재(이름은 보통 getRuntime() 아니면 getInstance()등을 사용 
		
		//Runtime rt = new Runtime();//불가능 내가 직접 생성하는 거
		Runtime rt = Runtime.getRuntime();//가능  생성해달라고 하는 거 
		
		//-외부 실행환경을 이용할 수 있도록 도와주는 클래스 
		
		System.out.println(rt.availableProcessors()); //CPU코어 개수
		System.out.println(rt.freeMemory()); //여유 메모리
		
		//rt.exec("터미널로 전송할 명령");
		try {
			//rt.exec("notepad");			//터미널에 notepad라고 입력하세요! 예외가 발생할 수 있다. 
			//rt.exec("start https://www.google.com"); //터미널에 start https://www.google.com라고 입력해줘-> 안열리는 이유:권한이 없음 
			//rt.exec("cmd /c start https://www.google.com"); //띄어쓰기 실수 가능성이 높음 
			//배열로 쳐라 
			String[] command = new String[] {"cmd", "/c", "start", "https://www.google.com"};
			rt.exec(command);//권장되는 방법(띄어쓰기는 자바가 해줄게!
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

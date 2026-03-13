package oop.inherit3;

public class ChromeBrowser  extends Browser { //이름에서 상속받았다는 걸 알수있어야 좋음. 
	public void develop() {
		System.out.println("개발자 도구 기능있어요");
	}
	public void chromeStore() {
		System.out.println("크롬스토어기능");
	}

}

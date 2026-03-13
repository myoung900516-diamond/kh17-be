package oop.inherit7;

public class ActionCamera extends Camera {

//	@Override
//	public void show() {
//		System.out.println(this.getName());
//		System.out.println(this.getResolution() + "만 화소");
//	}

	@Override
	public void on() {
		System.out.println("Action카메라의 전원을 켭니다");
	}

	@Override
	public void off() {
		System.out.println("Action카메라의 전원을 끕니다");
	}

	@Override
	public void takePhoto() {
		System.out.println("액션캠 촬영을 시작합니다");
	}

	@Override
	public void zoom() {
		System.out.println("떨림을 방지하며 확대를 시작합니다");
	}

	public ActionCamera(String name, int resolution) {
		super(name, resolution);
	}

}

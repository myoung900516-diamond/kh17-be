package oop.inherit7;

public class DroneCamera extends Camera{

//	@Override
//	public void show() {
//		System.out.println(this.getName());
//		System.out.println(this.getResolution() + "만 화소");
//	}

	@Override
	public void on() {
		System.out.println("Drone카메라의 전원을 켭니다");
	}

	@Override
	public void off() {
		System.out.println("Drone카메라의 전원을 끕니다");
	}

	@Override
	public void takePhoto() {
		System.out.println("항공 촬영을 시작합니다");
	}

	@Override
	public void zoom() {
		System.out.println("가까이 이동해서 촬영합니다");
	}

	public DroneCamera(String name, int resolution) {
		super(name, resolution);
	}

}

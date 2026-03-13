package oop.inherit7;

public class DSLRCamera extends Camera{

	@Override
	public void show() {
//		System.out.println(this.getName());
//		System.out.println(this.getResolution() + "만 화소");
////		super(name, resolution);
//		this.getName;
//		this.getResolution;
	}

	@Override
	public void on() {
		System.out.println("DSLR카메라의 전원을 켭니다");
	}

	@Override
	public void off() {
		System.out.println("DSLR카메라의 전원을 끕니다");
	}

	@Override
	public void takePhoto() {
		System.out.println("고화질 사진 촬영을 시작합니다");
	}

	@Override
	public void zoom() {
		System.out.println("광학 줌을 조절합니다");
	}

	public DSLRCamera(String name, int resolution) {
		super(name, resolution);
	}
	

}

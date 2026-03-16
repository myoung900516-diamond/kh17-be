package oop.multi2;

public class Tesla extends Vehicle implements Chargable, Autonomous {

	@Override
	public void autoDrive() {
		System.out.println("테슬라 자동주행기능");
	}
	@Override
	public void autoParking() {
		System.out.println("테슬라 자동주차기능");
	}
	@Override
	public void charge() {
		System.out.println("테슬라 충전기능");
	}
	@Override
	public void move() {
		System.out.println("테슬라 이동기능");
	}
	@Override
	public void startEngine() {
		System.out.println("테슬라 시동켬기능");
	}
	@Override
	public void stopEngine() {
		System.out.println("테슬라 시동끔기능");
	}
}

package oop.multi2;

public class Drone extends Vehicle implements Chargable, Flyable, Autonomous {

	@Override
	public void autoDrive() {
		System.out.println("드론 자동주행기능");
	}
	@Override
	public void autoParking() {
		System.out.println("드론 자동주차기능");
	}
	@Override
	public void fly() {
		System.out.println("드론 비행기능");
	}
	@Override
	public void charge() {
		System.out.println("드론 충전기능");
	}
	@Override
	public void move() {
		System.out.println("드론 이동기능");
		//this.fly(); 이것도 가능 
	}
	@Override
	public void startEngine() {
		System.out.println("드론 시동켬기능");
	}
	@Override
	public void stopEngine() {
		System.out.println("드론 시동끔기능");
	}
}

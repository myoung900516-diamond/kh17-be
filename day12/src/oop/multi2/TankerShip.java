package oop.multi2;

public class TankerShip extends Vehicle implements Refuelable, Sailable, Autonomous {

	@Override
	public void autoDrive() {
		System.out.println("대형유조선 자동주행기능");
	}
	@Override
	public void autoParking() {
		System.out.println("대형유조선 자동주차기능");
	}
	@Override
	public void sailable() {
		System.out.println("대형유조선 항해기능");
	}
	@Override
	public void refuel() {
		System.out.println("대형유조선 충전기능");
	}
	@Override
	public void move() {
		System.out.println("대형유조선 이동기능");
		//this.sail();도 가능 
	}
	@Override
	public void startEngine() {
		System.out.println("대형유조선 시동켬기능");
	}
	@Override
	public void stopEngine() {
		System.out.println("대형유조선 시동끔기능");
	}
}

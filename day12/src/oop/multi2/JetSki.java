package oop.multi2;

public class JetSki extends Vehicle implements Refuelable {

	@Override
	public void refuel() {
		System.out.println("제트스키 급유기능");
	}
	@Override
	public void move() {
		System.out.println("제트스키 이동기능");
	}
	@Override
	public void startEngine() {
		System.out.println("제트스키 시동켬기능");
	}
	@Override
	public void stopEngine() {
		System.out.println("제트스키 시동끔기능");
	}
}

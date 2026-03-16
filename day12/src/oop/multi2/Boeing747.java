package oop.multi2;

public class Boeing747 extends Vehicle implements Refuelable, Flyable{

	@Override
	public void fly() {
		System.out.println("보잉747 비행기능");
	}
	@Override
	public void refuel() {
		System.out.println("보잉747 급유 기능");
	}
	@Override
	public void move() {
		System.out.println("보잉747 이동기능");
		//this.fly();도 가능 
	}
	@Override
	public void startEngine() {
		System.out.println("보잉747 시동켬기능");
	}
	@Override
	public void stopEngine() {
		System.out.println("보잉747 시동끔기능");
	}
}

package oop.modifier1;

public class Car {
	
	private String name;
	private int speed;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSpeed(int speed) { 
		if(speed < 0)return;
		this.speed = speed;
	}
	public String getName() {
		return this.name;
	}
	public int getSpeed() {
		return this.speed;
	}
	

}

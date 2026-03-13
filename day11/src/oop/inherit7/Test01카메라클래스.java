package oop.inherit7;

public class Test01카메라클래스 {
	public static void main(String[] args) {
		//Camera k = new Camera("test", 3000); //추상클래스라서 객체생성이 불가능하다
		//일반클래스로 상위클래스를 구현하면 객체 생성이 된다. 
		DSLRCamera a = new DSLRCamera("DSLR", 400);
		
		a.show();
		a.on();
		a.off();
		a.takePhoto();
		a.zoom();
		
	ActionCamera b = new ActionCamera("Action", 4000);
		
		b.show();
		b.on();
		b.off();
		b.takePhoto();
		b.zoom();
		
	DroneCamera c = new DroneCamera("Drone", 40);
		
		c.show();
		c.on();
		c.off();
		c.takePhoto();
		c.zoom();
		
	}

}

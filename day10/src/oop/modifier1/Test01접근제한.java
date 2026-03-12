package oop.modifier1;

public class Test01접근제한 {
	public static void main(String[] args) {
		Car a = new Car();
		
		//a.speed = -500;//차단됨
		a.setSpeed(-500);
		
		//System.out.println(a.speed);//차단됨
		System.out.println(a.getSpeed());
	}

}

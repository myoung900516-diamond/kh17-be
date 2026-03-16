package oop.multi2;

public class Test01다중상속실습 {
	public static void main(String[] args) {
		VehicleR v = new VehicleR();
		
		Tesla t = new Tesla();
	//	v.setVehicle(vehicle);
		
		t.autoDrive();
		t.autoParking();
		t.charge();
		t.move();
		t.startEngine();
		t.stopEngine();
		
		Drone d = new Drone();
		d.charge();
		d.fly();
		d.autoDrive();
		d.autoParking();
		d.move();
		d.startEngine();
		d.stopEngine();
		
		TankerShip ts = new TankerShip();
		ts.autoDrive();
		ts.autoParking();
		ts.sailable();
		ts.refuel();
		ts.move();
		ts.startEngine();
		ts.stopEngine();
		
		JetSki j = new JetSki();
		j.refuel();
		j.move();
		j.startEngine();
		j.stopEngine();
		
		Boeing747 b = new Boeing747();
		b.refuel();
		b.fly();
		b.move();
		b.startEngine();
		b.stopEngine();
		
		
		//Vehicle v1 = new Tesla();
		
		
	}
}

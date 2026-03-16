package oop.keyword4;

public class Test01불변데이터 {
	public static void main(String[] args) {
		//불변(immutable) - 변하지 않는 것 <-> 가변(mutable)
		
		int a = 10;
		a = 20;
		a = 30;
		System.out.println("a = " + a);
		//변수는 가변. 덮어쓰기됨.
		//불변이 되어야 하는 것들 : 
		//-1년이 365일이라는것 
		//-1년이 12개월이라는 것
		//-일주일이 7일이라는 것
		//-1시간이 60분이라는 것 
		//-원주율이 3.141592이라는 것
		
		final double pi = 3.141592; //불변
		double r = 5; //가변 
		System.out.println(r * r * pi);
	}

}

package oop.poly1;

public class Test01다형성의활용 {
	public static void main(String[] args) {
		//우리의 목표는 : Box를 만들어서 후라이드 치킨 or 양념치킨을 보관시키는 것 
		
		Box box = new Box();
		
		//상자에 후라이드 치킨을 보관
		FriedChicken chicken = new FriedChicken();
		box.setChicken(chicken);//FriedChicken이 Chicken으로 업캐스팅되어 보관
		
		//상자에 양념 치킨을 보관
		SpicyChicken chicken2 = new SpicyChicken();
		box.setChicken(chicken2);//SpicyChicken이 Chicken으로 업캐스팅되어 보관
		
		
		
	}

}

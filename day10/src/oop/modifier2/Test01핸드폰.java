package oop.modifier2;

public class Test01핸드폰 {
	public static void main(String[] args) {
		Mobil m1 = new Mobil();
		Mobil m2 = new Mobil();
		Mobil m3 = new Mobil();
		Mobil m4 = new Mobil();
		
		m1.init("갤럭시 S26", 256, "SKT", 1797400, 24);
		m2.init("iPhone 17 Pro", 128, "KT", 1555000, 24);
		m3.init("갤럭시 S26 Ultra", 256, "LG", 1254000);
		m4.init("iPhone 17", 256, "알뜰폰", 1200000, 36);
		
		m1.show();
		m2.show();
		m3.show();
		m4.show();
		
	}

}

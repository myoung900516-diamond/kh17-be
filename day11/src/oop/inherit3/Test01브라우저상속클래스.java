package oop.inherit3;

public class Test01브라우저상속클래스 {
	public static void main(String[] args) {
		Chrome b1 = new Chrome();
		
		b1.url();
		b1.refresh();
		b1.move();
		b1.develop();
		b1.chromeStore();
		
		Edge b2 = new Edge();
		
		b2.url();
		b2.refresh();
		b2.move();
		b2.fullscreen();
		
		Whale b3 = new Whale();
		
		b3.url();
		b3.refresh();
		b3.move();
		b3.papago();
		b3.naverSearch();
		
	}

}

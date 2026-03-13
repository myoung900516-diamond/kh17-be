package oop.inherit3;

public class Test01브라우저상속클래스 {
	public static void main(String[] args) {
		ChromeBrowser b1 = new ChromeBrowser();
		
		b1.show();
		b1.refresh();
		b1.move();
		b1.develop();
		b1.chromeStore();
		
		EdgeBrowser b2 = new EdgeBrowser();
		
		b2.show();
		b2.refresh();
		b2.move();
		b2.fullscreen();
		
		WhaleBrowser b3 = new WhaleBrowser();
		
		b3.show();
		b3.refresh();
		b3.move();
		b3.papago();
		b3.naverSearch();
		
	}

}

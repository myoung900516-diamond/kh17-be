package oop.inherit3home;

public class Test01브라우저를클래스로구현 {
	public static void main(String[] args) {
		ChromeBrowser a = new ChromeBrowser("테스트.chrome");
		
		a.refresh();
		a.move();
		a.develop();
		a.chromeStore();
		
		EdgeBrowser b = new EdgeBrowser("테스트.chrome");
		
		b.refresh();
		b.move();
		b.fullscreen();
		
		WhaleBrowser c = new WhaleBrowser("테스트.chrome");
		
		c.refresh();
		c.move();
		c.papago();
		c.naverSearch();
	}

}

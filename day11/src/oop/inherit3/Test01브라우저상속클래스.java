package oop.inherit3;

public class Test01브라우저상속클래스 {
	public static void main(String[] args) {
		//Browser b = new Browser(); //작성되면 안되는 코드 
		ChromeBrowser b1 = new ChromeBrowser(); //밖에서는 상속이 티가 안난다. 
		
		//b1.show();
		b1.refresh(); //상속받은 기능 = 공통기능
		b1.move();//상속받은 기능 = 공통기능
		b1.develop();//고유 기능 
		b1.chromeStore(); //고유기능
		
		EdgeBrowser b2 = new EdgeBrowser();
		
		//b2.show();
		b2.refresh();
		b2.move();
		b2.fullscreen();
		
		WhaleBrowser b3 = new WhaleBrowser();
		
		//b3.show();
		b3.refresh();
		b3.move();
		b3.papago();
		b3.naverSearch();
		
	}

}


package oop.inherit3home;

public class ChromeBrowser extends Browser{

	public ChromeBrowser(String url) {
		super(url);
	}
	public void develop() {
		System.out.println("개발자도구기능");
	}
	public void chromeStore() {
		System.out.println("크롬스토어기능");
	}
	
	

}

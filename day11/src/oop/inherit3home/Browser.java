package oop.inherit3home;

public class Browser {
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public void refresh() {
		System.out.println("새로고침 기능");
	}
	public void move() {
		System.out.println("페이지 이동 기능");
	}

	public Browser(String url) {
		this.setUrl(url);
	}
	public void show() {
		System.out.println("주소 : " + this.url);
	}


}

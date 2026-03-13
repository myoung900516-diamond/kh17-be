package oop.inherit3;

public class Browser {
	private String url;
	public void refresh() {
		System.out.println("새로고침하기");
	}
	public void move() {
		System.out.println("페이지이동하기");
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
//	public void show() {
//		System.out.println("주소저장하기");
//	}

}

package oop.keyword1;
//삼각형 클래스
public class Triangle {
	//필드 
	private int width;
	private int height;
	//세터 + 게터 메소드
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		if(width <= 0)return;
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		if(height <= 0)return;
		this.height = height;
	}
	//생성자
	public Triangle(int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
	}
	//가상의 Getter
	public double getArea() {
		return this.width * this.height / 2.0;
	}

}

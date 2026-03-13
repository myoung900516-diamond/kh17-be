package oop.inherit7;

public abstract class Camera { 
	private String name;
	private int resolution;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getResolution() {
		return resolution;
	}
	public void setResolution(int resolution) {
		this.resolution = resolution;
	}
	
	public /*abstract*/ void show() {//명확한 메소드는 일반메소드로 한다. 
		System.out.println("<카메라정보>");
		System.out.println("카메라명 : " + this.getName());
		System.out.println("해상도 : " + this.getResolution() + "만 화소");
	}
		//System.out.println(this.getName());
		
	
	public abstract void on();
	public abstract void off();
	public abstract void takePhoto();
	public abstract void zoom();
	
	public Camera(String name, int resolution) {
		this.setName(name);
		this.setResolution(resolution);
	}
	
	

}

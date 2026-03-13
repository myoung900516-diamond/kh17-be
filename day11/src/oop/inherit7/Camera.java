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
	
	public abstract void show();
		//System.out.println(this.getName());
		
	
	public abstract void on();
	public abstract void off();
	public abstract void takePhoto();
	public abstract void zoom();
	
	public Camera(String name, int resolution) {
		super();
		this.name = name;
		this.resolution = resolution;
	}
	
	

}

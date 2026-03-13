package oop.inherit5;

public class Mp4File extends File{
	private int speed;
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		
		this.speed = speed;
	}
	public Mp4File(String filename, long filesize, int speed) {
		super (filename, filesize, speed);
	}
	
}

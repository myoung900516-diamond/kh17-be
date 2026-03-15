package oop.inherit5home;

public class Mp4File extends MediaFile {
	
	
	public Mp4File(String filename, long filesize) {
		super(filename, filesize);
		this.setSpeed(1f);
	}

	private float speed;

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		if(speed == 0.25f || speed == 0.5f || speed == 1f || speed == 1.25f || speed == 1.5f  || speed == 2f) {
			this.speed = speed;			
		}
	}
	public Mp4File(String filename, long filesize, float speed) {
		super(filename, filesize);
		this.setSpeed(speed);
	}

	@Override
	public void information() {
		super.information();
		System.out.println("배속 : x" + this.getSpeed());
	}
	

}

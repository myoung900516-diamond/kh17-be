package oop.inherit5home;

public class Mp3File extends MediaFile {

	private int duration;
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Mp3File(String filename, long filesize) {
		super(filename, filesize);
		this.setDuration(0);
	}
	public Mp3File(String filename, long filesize, int duration) {
		super(filename, filesize);
		this.setDuration(duration);
	}

	@Override
	public void information() {
		super.information();
		System.out.println("재생 시간 : " + this.getDuration() + "초");
	}
	

}

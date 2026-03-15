package oop.inherit5home;

public class MediaFile extends File {
	

	public MediaFile(String filename, long filesize) {
		super(filename, filesize);
}
	public void forward() {
		System.out.println("빨기감기기능");
	}
	public void rewind() {
		System.out.println("되감기기능");
	}
	
}

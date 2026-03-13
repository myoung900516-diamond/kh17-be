package oop.inherit5;

public class Mp3File extends File{
	private int duration;
	
	public Mp3File(String filename, long filesize, int duration) {
		super (filename, filesize, duration);
	}


}

package oop.inherit5;

public class PptFile extends File{
	public void slideShow() {
		System.out.println("슬라이드쇼기능");
	}
	
	public PptFile(String filename, long filesize, int pagesize) {
		super(filename, filesize, pagesize);
	}
}

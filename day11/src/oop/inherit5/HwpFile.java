package oop.inherit5;

public class HwpFile extends File {
	public void preview() {
		System.out.println("미리보기 기능");
	}
	
	
	public HwpFile(String filename, long filesize, int pagesize) {
		super(filename, filesize, pagesize);
	}

}

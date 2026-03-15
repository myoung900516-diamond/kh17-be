package oop.inherit5home;

public class File {
	
	private String filename;
	private long filesize;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		if(this.filesize < 0) return;
		this.filesize = filesize;
	}
	public void execute() {
		System.out.println("실행기능");
	}
	public File(String filename, long filesize) {
		this.setFilename(filename);
		this.setFilesize(filesize);
	}
	public void information() {
		System.out.println("파일 이름 : " + this.getFilename());
		System.out.println("파일 사이즈 : " + this.getFilesize());
	}

}

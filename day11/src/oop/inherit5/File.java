package oop.inherit5;

public class File {
	protected String filename;
	protected long filesize;
	protected int pagesize;
	
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
		this.filesize = filesize;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public void execute() {
		System.out.println("실행기능");
	}
	public void information() {
		System.out.println("정보출력기능");
	}
	public void forward() {
		System.out.println("빨리감기기능");
	}
	public void rewind() {
		System.out.println("되감기기능");
	}
	
	public File(String filename, long filesize, int pagesize) {
		this.setFilename(filename);
		this.setFilesize(filesize);
		this.setPagesize(pagesize);
		
	}
	public File(String filename, long filesize) {
		this.setFilename(filename);
		this.setFilesize(filesize);
		
	}
	

}

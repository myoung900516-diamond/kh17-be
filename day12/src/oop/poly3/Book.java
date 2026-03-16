package oop.poly3;

public class Book {
	
	private NoteBook notebook;

	public NoteBook getNotebook() {
		return notebook;
	}

	public void setNotebook(NoteBook notebook) {
		this.notebook = notebook;
	}
	
	public void power() {
		System.out.println("전원");
	}
	public void video() {
		System.out.println("동영상재생");
	}
	public void typing() {
		System.out.println("타이핑");
	}

}

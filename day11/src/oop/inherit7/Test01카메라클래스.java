package oop.inherit7;

public class Test01카메라클래스 {
	public static void main(String[] args) {
		DSLRCamera a = new DSLRCamera("DSLR", 4);
		
		a.on();
		a.off();
		a.takePhoto();
		a.zoom();
		
		
	}

}

package loop;

import java.io.File;

public class Test {
	public static void main (String[] args) {
		
	
	File file = new File("alarmsound.wav");

	if(file.exists()) {
	    System.out.println("파일 찾음");
	} else {
	    System.out.println("파일 없음");
	}
	}
}

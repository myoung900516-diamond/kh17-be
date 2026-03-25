package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03파일복사3 {
	public static void main(String[] args) throws IOException {
		File input = new File("D:\\kh17\\eclipse-java-2025-12-R-win32-x86_64\\eclipse", ".eclipseproduct");
		File output = new File("files", "copybig.kh");
		
		//파일을 만들자
		//b.createNewFile(); 소용없다
		
		//가져오자
		if(!input.exists()) return;
		FileInputStream a = new FileInputStream(input);	
		FileOutputStream b = new FileOutputStream(output);
		
		while(true) {
		//for(int i = 0; i < 1; i++) {
			int n = a.read();
			if(n==-1)break; 
			b.write(n);
			//System.out.println("n= " + n);
			//보내자
		}
		b.close();
		a.close();
		
		
	}

}

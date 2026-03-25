package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03파일복사2 {
	public static void main(String[] args) throws IOException {
		File input = new File("files", "single.kh");
		File output = new File("files", "copy.kh");
		
		//파일을 만들자
		//b.createNewFile(); 소용없다
		
		//가져오자
		if(!input.exists()) return;
		FileInputStream a = new FileInputStream(input);	
		FileOutputStream b = new FileOutputStream(output);
		
		
			int n = a.read();
			b.write(n);
			
			b.close();
			a.close();

		
	}

}

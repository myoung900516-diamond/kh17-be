package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;


public class Test06로또번호출력기 {
	public static void main(String[] args) throws Exception {
		
		File target = new File("files", "lotto.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		DataInputStream data = new DataInputStream(buffer);
		
		try {
			while(true) {
				int lotto = data.readInt();
				System.out.println("로또번호 = " + lotto);
			}
		}
		catch(Exception e) {
		}
		
		//이거는 모듈화가 안됨

//		// 로또번호 = 6
//		로또번호 = 18
//				로또번호 = 27
//				로또번호 = 34
//				로또번호 = 37
//				로또번호 = 45


		data.close();
		
	}

}

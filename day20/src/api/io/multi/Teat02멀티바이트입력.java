package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Teat02멀티바이트입력 {
	public static void main(String[] args) throws Exception {
		//멀티바이트입력
		//-딱 내보낸 만큼만 읽어야함 
		
		//준비물 생성 
		File target = new File("files", "multi.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		DataInputStream data = new DataInputStream(buffer);
		
		//구조: [프로그램] ← [data] ← [buffer] ← [stream] ← [target] ← [실제파일]
		
		//입력은 data를 이용해서 데이터의 종류별 입력 명령을 사용한다 
		int a = data.readInt(); //파일에서 4byte 읽어와서 int로 만들어서 내놔! 
		double b = data.readDouble(); //파일에서 8byte 읽어와서 double로 만들어서 내놔!
		char c = data.readChar();//파일에서 2byte 읽어와서 char로 만들어서 내놔!
		float d = data.readFloat(); //파일에서 4byte 읽어와서 float로 만들어서 내놔!
		long e = data.readLong(); //파일에서 8byte 읽어와서 long로 만들어서 내놔!
		
		//통로정리 
		data.close();
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
		
	}

}

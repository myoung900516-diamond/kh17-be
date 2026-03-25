package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02바이트입력2 {
	public static void main(String[] args) throws IOException {
		//바이트입력
		//- 파일에 저장된 글자를 바이트 단위로 끊어서 읽는 작업 
		//-실제 파일에 저장된 데이터가 바이트가 아니어도 됨
		//-준비물: 파일 객체 + 파일 입력 스트림 
		
		
		File input = new File("files", "single.kh");
		if(!input.exists()) return;
		FileInputStream stream = new FileInputStream(input);
		
		//stream의 입력명령인 read()를 사용하여 1byte씩 읽는다
		while(true) {
			int n = stream.read();
			if(n==-1)break; //EOF(End-Of-File)발견시 나가라 
			System.out.println("n= " + n);
		}
		//일반적인 입력 코드(EOF까지만 읽어라)
//		stream.read();
//		stream.read();
//		stream.read();
//		stream.read();
//		stream.read();
//		stream.read();
//		stream.read();
//		stream.read();
//		stream.read();
//		stream.read();
		
		stream.close();
	}

}

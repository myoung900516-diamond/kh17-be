package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02바이트입력 {
	public static void main(String[] args) throws IOException {
		//바이트입력
		//- 파일에 저장된 글자를 바이트 단위로 끊어서 읽는 작업 
		//-실제 파일에 저장된 데이터가 바이트가 아니어도 됨
		//-준비물: 파일 객체 + 파일 입력 스트림 
		
		
		File input = new File("files", "single.kh");
		if(!input.exists()) return;
		FileInputStream stream = new FileInputStream(input);
		
		//stream의 입력명령인 read()를 사용하여 1byte씩 읽는다
//		for(int i = 0; i <11; i++) {
		for(int i = 0; i < input.length(); i++) {//파일의 글자수만큼
			int n = stream.read();
			System.out.println("n= " + n);
		}
		//변수가 많아서 for사용은 비추천 
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

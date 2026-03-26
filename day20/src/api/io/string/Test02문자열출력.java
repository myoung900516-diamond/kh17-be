package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test02문자열출력 {
	public static void main(String[] args) throws IOException {
		//FileOutputStream 대신 여러 처리가 추가되어 있는 FileWriter를 사용
		//크기 조절이 가능한 외장 버퍼 (BufferedWriter)추가 
		
		File target = new File("files", "string2.kh");
		FileWriter writer = new FileWriter(target);
		BufferedWriter buffer = new BufferedWriter(writer); //8192);
		
		//writer를 이용해서 문자열을 출력 
		//writer.write("안녕하세요 반갑습니다");
		buffer.write("안녕하세요 반갑습니다\n");
		buffer.write("안녕하세요 반갑습니다\n");//엔터는 
		buffer.write(100);//알파벳d를 말하는 걸까? 
	
		//비우기 및 종료
		//writer.close();
		buffer.close();
	}
}

package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test02문자열출력2 {
	public static void main(String[] args) throws IOException {
		//FileOutputStream 대신 여러 처리가 추가되어 있는 FileWriter를 사용
		//크기 조절이 가능한 외장 버퍼 (BufferedWriter)추가 
		//출력의 자유도를 높여주는 보조 출력도구(PrintWriter)추가 
		
		File target = new File("files", "string2.kh");
		FileWriter writer = new FileWriter(target);
		BufferedWriter buffer = new BufferedWriter(writer); //8192);
		PrintWriter printer = new PrintWriter(buffer);
		
		//printer를 이용해서 다양한 데이터를 출력
		//-write 대신 print명령이 나옴
		printer.println("안녕하세요 반갑습니다");
		printer.println("안녕하세요 반갑습니다");
		printer.println(100 + 200);
		printer.println(3.141592);
	
		//비우기 및 종료
		//writer.close();
		//buffer.close();
		printer.close();
	}
}

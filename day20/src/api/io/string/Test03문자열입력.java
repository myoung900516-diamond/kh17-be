package api.io.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test03문자열입력 {
	public static void main(String[] args) throws Exception {
//		문자열 입력
//		-FileInputStream으로도 가능하지만 변환을 내가 직접 하고 버퍼도 내가 설정한다는 문제가 있음 
//		-FileReader로 입력을 받으면 변환을 자동으로 해주지만 지정한 글자수만 ㅇ릭을 수 있음 (ex:10글자)
//		-BufferedReader로 입력을 받으면 "한 줄"씩 읽는 것이 가능해진다(버퍼 자동설정)
//		-PrintReader는 없음!
		
//		입력준비
		File target = new File("files", "string2.kh");
		FileReader reader = new FileReader(target);
		BufferedReader buffer = new BufferedReader(reader);
		
//		입력
		String line = buffer.readLine();// 1줄을 읽으세요! 무조건 1줄이지만 성능이 매우 좋음 
		System.out.println("line = " + line);
		
		line = buffer.readLine();
		System.out.println("line = " + line);
		line = buffer.readLine();
		System.out.println("line = " + line);
		line = buffer.readLine();
		System.out.println("line = " + line);
		line = buffer.readLine();
		System.out.println("line = " + line);
		line = buffer.readLine();
		System.out.println("line = " + line);
		line = buffer.readLine();
		System.out.println("line = " + line);
		
		buffer.close();
		
	}

}

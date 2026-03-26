package api.io.string;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test01문자열과바이트 {
	public static void main(String[] args) throws IOException {
		//목표: 문자열과 바이트의 상호 변환
		
		//문자열 → 바이트
		String a1 = "Hello Java";
		String a2 = "안녕 자바";
		
		byte[] b1 = a1.getBytes();
		byte[] b2 = a2.getBytes();//말 안하면 UTF-8
		//byte[] b2 = a2.getBytes("MS949");
		
		System.out.println(Arrays.toString(b1));
		System.out.println(Arrays.toString(b2));
		
		File target = new File("files", "string.kh");
		FileOutputStream stream = new FileOutputStream(target);
		
		stream.write(b2);
		
		stream.close();
		
	}

}

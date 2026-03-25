package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Test05바이트배열입력 {
	public static void main(String[] args) throws Exception {
		//바이트 배열을 이용한 입력 
		//-한번에 다읽을 생각은 없음 
		//-17글자니까 한 5글자씩 읽어보면서 생각하자!
		
		//준비물
		File target = new File("files", "single2.kh");//파일 객체
		FileInputStream stream = new FileInputStream(target);//입력용 통로 객체
		byte[] buffer = new byte[5];
		
		//읽을 때 한글자씩 읽지말고 buffer에 꽉 채워서 읽자! 
		
		while(true) {
			
			int size = stream.read(buffer);//buffer에 꾹 눌러담아서 읽어라! 
			if(size == -1) break;//EOF발견 시 탈출
			System.out.println(Arrays.toString(buffer) + ", " + size);//예쁘게 출력
		}
		
		
//		 size = stream.read(buffer);//buffer에 꾹 눌러담아서 읽어라! 
//		System.out.println(Arrays.toString(buffer) + ", " + size);//예쁘게 출력
//		
//		 size = stream.read(buffer);//buffer에 꾹 눌러담아서 읽어라! 
//		System.out.println(Arrays.toString(buffer) + ", " + size);//예쁘게 출력
//		
//		 size = stream.read(buffer);//buffer에 꾹 눌러담아서 읽어라! 
//		System.out.println(Arrays.toString(buffer) + ", " + size);//예쁘게 출력
//		
//		size = stream.read(buffer);//buffer에 꾹 눌러담아서 읽어라! 
//		System.out.println(Arrays.toString(buffer) + ", " + size);//예쁘게 출력
//		
		//사용한 통로 정리
		stream.close();
		
	
	}

}

package api.io.single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test04바이트배열출력 {
	public static void main(String[] args) throws Exception {
		//목표 : 바이트출력을 "배열"을 이용하여 한 번에 처리
		
		//준비
		File target = new File("files", "single2.kh");//파일 객체
		FileOutputStream stream = new FileOutputStream(target);//통로 객체
		
		//stream.write('h');//한 글자씩 내보내는 것 
		
		byte[] data = new byte[] { 104, 101, 108, 108, 111, 32, 106, 97, 118, 97, 33};//hello java!
		stream.write(data);//data 배열에 저장된 값을 한번에 출력하란뜻(반복문과는 다름)
		stream.write('\n');//줄바꿈
		stream.write(data, 3, 5); //3번위치부터 5개 
				
		
		//사용한 통로 정리
		stream.close();
	}

}

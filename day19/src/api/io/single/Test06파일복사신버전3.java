package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test06파일복사신버전3 {
	public static void main(String[] args) throws Exception {
		//목표 : 바이트배열을 이용하여 파일복사의 성능을 향상시키는 것 + 최적의 버퍼 크기를 찾는 것 
		
		//준비물은 전과 동일 (버퍼 역할을 할 배열이 추가)
		File readTarget = new File("files", "single2.kh");//입력용 파일
		FileInputStream readStream = new FileInputStream(readTarget);//입력용 통로
		File writeTarget = new File("files", "copy2.kh");//출력용 파일
		FileOutputStream writeStream = new FileOutputStream(writeTarget); //출력용 통로
		byte[] buffer = new byte[5];
		
		//한 덩어리를 복사 
		int size = readStream.read(buffer); //buffer에 가득 채워 읽고 실제로 얼마 읽었는지 size에 반환하세요
		writeStream.write(buffer, 0, size);//buffer에 있는 모든 데이터를 내보내세요!
		
		size = readStream.read(buffer);
		writeStream.write(buffer, 0, size);
		
		size = readStream.read(buffer);
		writeStream.write(buffer, 0, size);//시작지점부터 읽은 개수만큼 내보내세요
		
		//통로 정리
		writeStream.close();
		readStream.close();
	
	}

}

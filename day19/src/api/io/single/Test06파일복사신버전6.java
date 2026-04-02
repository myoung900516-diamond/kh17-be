package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test06파일복사신버전6 {
	public static void main(String[] args) throws Exception {
		//목표 : 바이트배열을 이용하여 파일복사의 성능을 향상시키는 것 + 최적의 버퍼 크기를 찾는 것 
		
		//준비물은 전과 동일 (버퍼 역할을 할 배열이 추가)
		File readTarget = new File("files", "single2.kh");//입력용 파일
		FileInputStream readStream = new FileInputStream(readTarget);//입력용 통로
		File writeTarget = new File("files", "copy2.kh");//출력용 파일
		FileOutputStream writeStream = new FileOutputStream(writeTarget); //출력용 통로
		byte[] buffer = new byte[8192];//많다고 좋지 않음 //2의 곱으로 숫자을 늘려감 
		
		//한 덩어리를 복사 
		long begin = System.currentTimeMillis();
		while(true) {
			int size = readStream.read(buffer); //buffer에 가득 채워 읽고 실제로 얼마 읽었는지 size에 반환하세요
			if(size == -1) break;//EOF
			writeStream.write(buffer, 0, size);//시작지점부터 읽은 개수만큼 내보내세요
			
		}
		long end = System.currentTimeMillis();
		long time = end - begin;
		System.out.println("소요시간 : " + time + "ms");
		//통로 정리
		writeStream.close();
		readStream.close();
	
	}

}

package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Test01멀티바이트출력 {
	public static void main(String[] args) throws Exception {
		//원시형 데이터(raw type)와 같은 크기가 정해진 멀티바이트의 출력
		//-준비물 : 파일객체, 출력통로, 임시저장소, 분해도구
		
		//디렉터리가 없어서 디렉터리를 만들어야 하는 경우
		File dir = new File("files");
		dir.mkdirs();//디렉터리 생성(mkdir() : 1차 폴더까지만 생성, mkdirs :전체를 다 생성)
		
		File target = new File("files", "multi.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		DataOutputStream data = new DataOutputStream(buffer);
		//최종구조 : [프로그램]→ [data] → [buffer] → [stream] → [target] → [실제파일]
		//분해도구(data)에게 어떤 종류의 데이터인지 알려주면서 출력을 지시 
		data.writeInt(100);//100을 int로 생각하고 조각내서 출력하라 
		data.writeDouble(100);//100을 double로 생각하고 조각내서 출력하라 
		data.writeChar(100);//100을 char로 생각하고 조각내서 출력하라 
		data.writeFloat(100);//100을 Float로 생각하고 조각내서 출력하라 
		data.writeLong(100);//100을 Long로 생각하고 조각내서 출력하라 
		
		//정리코드
		//정리코드를 써야 출력이됨 왜? 
		//data.flush();//남아있는 데이터를 밀어내라! 
		data.close();//남아있는 데이터를 밀어내고 통로를 폐쇄해라! 
		//buffer.close();//안해도됨
		//stream.close();//안해도됨
	}

}

package api.file;

import java.io.File;
import java.io.IOException;

public class Test02파일생성삭제2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		//파일을 만들 때도 파일 객체가 필요 (없는 대상을 만들어서 가리켜야함)
		
		//File target = new File("files/new.txt");
		File target = new File("files", "new.txt");
		
		System.out.println("파일이 있나요? =" +target.exists());
		
		boolean isCreated = target.createNewFile();
		System.out.println("생성 여부 = " + isCreated);
		//f5는 새로고침 
		
		target.setWritable(false);//작성금지야(읽기 전용)
		
		//5~10초 후 삭제되도록 처리 
		Thread.sleep(5000L);//5초 정지
		
		//target.delete();//파일 삭제
		File target2 = new File("files", "change.txt");
		target.renameTo(target2);
	}

}

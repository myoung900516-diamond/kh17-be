package api.file;

import java.io.File;
import java.io.IOException;

public class Test01파일다루기 {
	public static void main(String[] args) throws IOException {
		//파일을 만들고 만든 파일의 정보를 프로그래밍 코드로 읽어서 출력
		//-파일은 실제로 존재해야함(코드로 만들어도 되고 직접 생성해도 되고)
		//-같은 프로젝트에 만들면 짧은 경로(상대경로)로 찾을 수 있고, 외부에 만들면 전체 경로(절대경로)를 다 작성해야 찾을 수 있다

		//파일 제어를 위한 객체 생성
		//-경로를 다 적지 않으면 자동으로 같은 프로젝트 내에서 찾음(상대경로, Relative Path)
//		File a = new File("전체경로");
		File a = new File("files/hello.txt");
//		File b = new File("경로1", "경로2");
		File b = new File("files", "hello.txt");
		
		//파일이 실제로 존재하는지 확인
		System.out.println("a가 존재하는가 = " + a.exists());
		System.out.println("b가 존재하는가 = " + b.exists());
		
		//파일인지 디렉터리인지 확인 
		//-파일은 총 3가지 상태가 있을 수 있음(없음, 파일, 디렉터리)
		System.out.println("a가 파일인가 = " + a.isFile());
		System.out.println("a가 디렉터리인가 = " + a.isDirectory());
		
		if(a.isFile()) {//a가 파일일 때만 작업을 진행할게
			//파일 정보 분석
			System.out.println("이름 = "+ a.getName());
			System.out.println("위치 = " + a.getPath());//생성 시 입력한 경로 
			System.out.println("위치 = " + a.getAbsolutePath());//실체 위치(전체 경로) 절대경로
			System.out.println("위치 = " + a.getCanonicalPath()); //깔끔한 위치 (불필요한 글자 제거)
			System.out.println("크기 = " + a.length());//파일의 크기 = 파일에 들어있는 글자의 길이 
			} 
		
		
	}

}

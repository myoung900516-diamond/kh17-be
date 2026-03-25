package api.file;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

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
			System.out.println("위치 = " + a.getPath());//생성 시 입력한 경로  상대경로
			System.out.println("위치 = " + a.getAbsolutePath());//실체 위치(전체 경로) 절대경로
			System.out.println("위치 = " + a.getCanonicalPath()); //깔끔한 위치 (불필요한 글자 제거)
			System.out.println("크기 = " + a.length());//파일의 크기 = 파일에 들어있는 글자의 길이 
			System.out.println("파일 최종 수정시각 = " + a.lastModified());
			
			//Format() = new SimpleDateFormat
			Date d = new Date(a.lastModified());
			Format f = new SimpleDateFormat("y년 M월 d일 a h:mm:ss");
			System.out.println("최종 수정 시각 = " + f.format(d));
			
			
			//파일의 상태 분석 
			System.out.println("읽기 가능? = " + a.canRead());
			System.out.println("쓰기 가능? 내용 변경 가능? =" + a.canWrite());
			System.out.println("실행 가능? =" + a.canExecute());
			System.out.println("숨김 파일 = " + a.isHidden());
			
			//(Q)이 파일의 확장자를 출력해보세요
			//-확장자는 파일의 마지막에 있는 '.' 뒤의 글자
			//-파일의 종류를 구분할 수 있으며 운영체제에서 이 확장자에 따라 실행해야할 프로그램을 결정
			//-확장자는 없을 수 있으며 없어도 아무 문제가 없음
			String name = a.getName();//파일명 추출
			int dotPosition = name.lastIndexOf(".");//맨 오른쪽 점의 위치를 찾아라
			if(dotPosition == -1 || name.endsWith(".")) {//점이 없거나 점으로 끝나면 확장자 없음
				System.out.println("확장자가 없는 파일입니다");
				
			}
			else {//나머지는 확장자 있음
				String extension = name.substring(dotPosition);
				System.out.println("확장자 : " + extension);
				System.out.println(dotPosition);
			}
			//a.getPath().get
			//System.out.println("확장자? = " + a.getPath().substring(8));
			} 
		
		
	}

}

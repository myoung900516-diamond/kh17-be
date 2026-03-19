package api.lang.etc;

public class Test02시스템클래스 {
	public static void main(String[] args) {
		//System 클래스
		//-생성자가 없습니다. 
		//-프로그램 외부 시스템(ex: 운영체제)의 정보를 불러오는 클래스 (그래서 필수 패키지)
		//-객체 생성은 불가(이미 설정된 정보만 이용 가능)
		
		//1.시스템의 시간을 읽어올 수 있어요. 
		//시간을 보여주는 용도는 아님 
		//-계산용 시간정보(시간차 구할 때 사용)
		//-기준시간이 UTC = 1970년 1월 1일 0시 0분 0초
		//UTC로부터 지금까지 진행된 시간을 밀리초로 반환 
		long current = System.currentTimeMillis();
		System.out.println("현재시각 = " + current);
		
		
		//2.시스템의 정보 읽기(환경변수 등)
		//System.out.println(System.getProperties());//읽을 수 있는 모든 정보를 출력(엄청 많음)
		System.out.println(System.getProperty("os.name"));//운영체제의 이름
		System.out.println(System.getProperty("user.country"));//운영체제에 설정된 지역
		System.out.println(System.getProperty("user.language"));//운영체제에 설정된 언어 
		System.out.println(System.getProperty("java.version"));//이 pc에 설치된 자바 버전 
		System.out.println(System.getProperty("user.home"));//현재 사용자의 전용 폴더
		System.out.println(System.getProperty("user.dir"));//프로그램이 실행되는 폴더 
		
		//운영체제 탐지
		String name = System.getProperty("os.name");
		if(name.toLowerCase().startsWith("windows")) {
			System.out.println("윈도우 사용중이시네요");
		}
		else if(name.toLowerCase().startsWith("mac")) {
			System.out.println("맥 사용중이시네요");
		}
		//3.각종 스트림(통로)을 필드로 가짐 
		//-표준 출력: System.out
		//-표준 입렵: System.in
		//-표준 오류 : System.err
		//System.err.println("테스트"); //순서를 보장할 수 없음 색상쓰려고 쓰면 안 됨 
		//System.out.println("테스트");
		
		//4. 시스템의 종료 기능 사용(프로그램 종료)
		System.exit(0);//x누르면 실행됨 
		System.out.println("이 메세지는 안나와서");
		
		
		
	}

}

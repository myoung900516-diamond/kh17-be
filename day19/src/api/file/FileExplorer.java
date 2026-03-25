package api.file;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExplorer {
		//필드
		private String path;
	
		//메소드
		public void setPath(String path) {
			//String regex = "^[^\\\\\\/\\:\\*\\?\\\"\\<\\>\\|]+$"; 
		//	if(path == null || path.matches(regex)) {
				this.path = path;
			}
	//	}
		public String getPath() {
			return path;
		}
		//생성자
		public FileExplorer() {}
		public FileExplorer(String path) {
			this.setPath(path);
		}
		public void show(){
			File a = new File(this.path);
			
			if(a.exists() == false) {
				System.out.println("존재하지 않는 경로입니다");
			}
			
			System.out.println("파일인가 = " + a.isFile());
			
			if(a.isFile() == true) {
				System.out.println("파일의 경로 = " + a.getAbsolutePath());
				System.out.println("파일의 이름 = " + a.getName());
				System.out.println("파일의 크기 = " + a.length());
				System.out.println("최종수정일 = " + a.lastModified());
				Date d = new Date(a.lastModified());
				Format f = new SimpleDateFormat("y년 M월 d일 a h:mm:ss");
				System.out.println("최종 수정 시각 = " + f.format(d));
				
			}
			System.out.println("디렉터리인가 = " + a.isDirectory());
			if(a.isDirectory() == true) {
				File[] files = a.listFiles();
				for(File file : files) {
					if(file.isFile() == true) {
						System.out.println("----------------파일목록--------------");
						System.out.println("파일 위치 = " + file.getAbsolutePath());
						System.out.println("파일 명 = " + file.getName());
						System.out.println("파일  크기 = " + file.length());
						System.out.println("파일  최종 수정일 = " + file.lastModified());
						Date d = new Date(a.lastModified());
						Format f = new SimpleDateFormat("y년 M월 d일 a h:mm:ss");
						System.out.println("최종 수정 시각 = " + f.format(d));
					}
					else {
						System.out.println("----------------디렉토리목록--------------");
						System.out.println("디렉터리 위치 = " + file.getAbsolutePath());
						System.out.println("디렉터리 명 = " + file.getName());
						System.out.println("디렉터리 크기 = " + file.length());
						System.out.println("디렉터리 최종 수정일 = " + file.lastModified());
						Date d = new Date(a.lastModified());
						Format f = new SimpleDateFormat("y년 M월 d일 a h:mm:ss");
						System.out.println("최종 수정 시각 = " + f.format(d));
					}
				}
			}
		}
		
		public void move(String input) {
			//원래 가진 path와 전달받은 input을 잘~~~ 합쳐서 하나의 경로로 완성시킨다
			//문자열 계산을 하면 안되기 때문에 파일로 변환해서 계산
			
			if(path == null) {//주소가 설정된 적이 없음
				this.setPath(input);
			}
			else {//이미 어딘가를 보고 있음
				File current = new File(path);//현재위치
				File destination = new File(current, input);//현재위치 안에서 입력된위치를 지정
				this.setPath(destination.getAbsolutePath());//주소창을 목적지의 절대경로로 변경
			}
		}
	
		}


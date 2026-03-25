package api.file;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test04미니탐색기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력하세요");
		String path = sc.next();
		
		File a = new File("path");
		
		
		System.out.println("존재 여부 = " + a.exists());
		
		
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
		sc.close();
	}

}

package oop.inherit5;

public class Test01파일상속클래스실습 {
	public static void main(String[] args) {
		Mp4File f1 = new Mp4File("이름4", 500, 500);
		
//		f1.getFilename();
//		f1.getFilesize();
//		f1.speed();
		f1.forward();
		f1.rewind();
		f1.information();
		
		
		Mp3File f2 = new Mp3File("이름3", 800, 500);
		
//		f2.getFilename();
//		f2.getFilesize();
//		f2.duration();
		f2.execute();
		f2.forward();
		f2.rewind();
		f2.information();
		
		HwpFile f3 = new HwpFile("한글파일", 1000, 400);
		
//		f3.getFilename();
//		f3.getFilesize();
		//f3.getPagesize();
		f3.execute();
		f3.preview();
		f3.information();
		
		
		PptFile f4 = new PptFile("파워포인트파일",  1000, 600);
		
//		f4.getFilename();
//		f4.getFilesize();
//		f4.getFilesize();
		f4.execute();
		f4.slideShow();
		f1.information();
		
		
		
		
	}

}

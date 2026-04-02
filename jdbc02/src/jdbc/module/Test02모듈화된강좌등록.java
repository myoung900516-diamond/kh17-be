package jdbc.module;

import java.util.Scanner;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test02모듈화된강좌등록 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		LectureDto lectureDto = new LectureDto();
		System.out.print("강좌명 : ");
		lectureDto.setLectureTitle(sc.nextLine());
		System.out.print("카테고리(이론/실습/시험) : ");
		lectureDto.setLectureCategory(sc.nextLine());
		System.out.print("수강시간(30시간단위) : ");
		lectureDto.setLectureDuration(sc.nextInt());
		System.out.print("수강료(1000원단위) : ");
		lectureDto.setLecturePrice(sc.nextInt());
		sc.nextLine();
		System.out.print("강의형태(온라인/오프라인/혼합) : ");
		lectureDto.setLectureType(sc.nextLine());
		sc.close();
		
		
//		LectureDto lectureDto = new LectureDto();
//		lectureDto.setLectureTitle("SQLD준비");
//		lectureDto.setLectureCategory("시험");
//		lectureDto.setLectureDuration(90);
//		lectureDto.setLecturePrice(600000);
//		lectureDto.setLectureType("온라인");
		
		LectureDao lectureDao = new LectureDao();
		lectureDao.insert(lectureDto);
		
		System.out.println("complete");
	}

}

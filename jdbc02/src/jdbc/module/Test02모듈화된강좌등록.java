package jdbc.module;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test02모듈화된강좌등록 {
	public static void main(String[] args) {
		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureTitle("SQLD준비");
		lectureDto.setLectureCategory("시험");
		lectureDto.setLectureDuration(90);
		lectureDto.setLecturePrice(600000);
		lectureDto.setLectureType("온라인");
		
		LectureDao lectureDao = new LectureDao();
		lectureDao.insert(lectureDto);
		
		System.out.println("complete");
	}

}

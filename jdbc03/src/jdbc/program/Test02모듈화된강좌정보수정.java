package jdbc.program;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test02모듈화된강좌정보수정 {
	public static void main(String[] args) {
		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureNo(3);
		lectureDto.setLectureTitle("정보처리기사 실기");
		lectureDto.setLectureCategory("시험");
		lectureDto.setLectureDuration(90);
		lectureDto.setLecturePrice(90000);
		lectureDto.setLectureType("온라인");
		
		LectureDao lectureDao = new LectureDao();
		boolean success = lectureDao.update(lectureDto);
		
		if(success) {
			System.out.println("강좌정보가 수정되었습니다");
		}
		else {
			System.out.println("등록되지 않은 정보입니다");
		}
	}

}

package jdbc.program;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test12강좌상세정보 {
	public static void main(String[] args) {
		int lectureNo = 7;
		
		LectureDao lectureDao = new LectureDao();
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		
		System.out.println(lectureDto);
	}

}

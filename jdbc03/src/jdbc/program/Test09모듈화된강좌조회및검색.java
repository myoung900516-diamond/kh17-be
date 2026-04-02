package jdbc.program;

import java.util.List;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test09모듈화된강좌조회및검색 {
	public static void main(String[] args) {
		String column = "";
		String keyword = "";
		
		LectureDao lectureDao = new LectureDao();
		List<LectureDto> list = lectureDao.selectList(column, keyword);
		lectureDao.selectList();
		
		for(LectureDto lectureDto : list) {
			System.out.println(lectureDto);
		}
	}
}

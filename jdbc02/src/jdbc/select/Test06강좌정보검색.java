package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test06강좌정보검색 {
	public static void main(String[] args) {
		//입력
		String column = "lecture_title";
		String keyword = "기사";
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
//		String sql = "select * from lecture where instr("+column+", ?) > 0 order by lecture_no asc";
		String sql = "select * from lecture where "+column+" like ? order by lecture_no asc";
		String sql2 = "select * from lecture order by lecture_no asc";
		Object[] params = {"%"+keyword+"%"};
		LectureMapper lectureMapper = new LectureMapper();
		List<LectureDto> list = jdbcTemplate.query(sql, lectureMapper, params);
		List<LectureDto> list2 = jdbcTemplate.query(sql2, lectureMapper);
		//출력
		if(list.size() == 0) {
			for(LectureDto lectureDto2 : list2) {
				System.out.println(lectureDto2);
			}
		}
		else {
			for(LectureDto lectureDto : list) {
				System.out.println(lectureDto);
			}
		}
		
	}

}

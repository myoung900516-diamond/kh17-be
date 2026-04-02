package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.LectureDto;
import jdbc.util.JdbcUtils;

public class LectureDao {
	public void insert(LectureDto lectureDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "insert into lecture(lecture_no, lecture_title, lecture_category, "
				+ "lecture_duration, lecture_price, lecture_type)"
				+ "values(lecture_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] params = {lectureDto.getLectureTitle(), lectureDto.getLectureCategory(), 
				lectureDto.getLectureDuration(), lectureDto.getLecturePrice(), 
				lectureDto.getLectureType()};
		
		jdbcTemplate.update(sql, params);
		
		
		}
	
	public boolean update(LectureDto lectureDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		
		String sql = "update lecture "
				+ "set lecture_title = ?, lecture_category=?, lecture_duration=?, "
				+ "lecture_price=?, lecture_type=? "
				+ "where lecture_no=?";
		Object[] params = {
				lectureDto.getLectureTitle(), lectureDto.getLectureCategory(), 
				lectureDto.getLectureDuration(), lectureDto.getLecturePrice(), 
				lectureDto.getLectureType(), lectureDto.getLectureNo()
		};
//		int rows = jdbcTemplate.update(sql, params);
//		return rows > 0;
		
		return jdbcTemplate.update(sql, params) >0 ;
		
	}
	}

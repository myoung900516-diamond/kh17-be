package jdbc.dao;

import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BookDto;
import jdbc.dto.LectureDto;
import jdbc.mapper.BookMapper;
import jdbc.mapper.LectureMapper;
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
	public boolean delete(int lectureNo) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "delete lecture where lecture_no = ?";
		Object[] params = {lectureNo};
		
		return jdbcTemplate.update(sql, params)>0;
	}
	
	public List<LectureDto> selectList(){
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from lecture order by lecture_no asc";
		LectureMapper lectureMapper = new LectureMapper();
		
		return jdbcTemplate.query(sql, lectureMapper);
	}
	
	public List<LectureDto> selectList(String column, String keyword){
		
		if(column == null || keyword == null) return selectList();
		
		Set<String> allowList = Set.of("lecture_title", "lecture_category", "lecture_type");
		if(allowList.contains(column) == false) return selectList();
		
		
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from lecture where instr("+column+", ?)>0 order by lecture_no asc";
		Object[] params = {keyword};
		LectureMapper lectureMapper = new LectureMapper();
		return jdbcTemplate.query(sql, lectureMapper, params);
	}
	
	public LectureDto selectOne(int lectureNo) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from lecture where lecture_no =?";
		Object[] params = {lectureNo};
		LectureMapper lectureMapper = new LectureMapper();
		List<LectureDto> list = jdbcTemplate.query(sql, lectureMapper, params);
		return list.isEmpty() ? null : list.get(0);

	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

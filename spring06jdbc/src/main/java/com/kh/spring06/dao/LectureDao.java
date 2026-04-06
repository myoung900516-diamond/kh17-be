package com.kh.spring06.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.LectureDto;
import com.kh.spring06.mapper.LectureMapper;




@Repository
public class LectureDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private LectureMapper lectureMapper;
	
	public void insert(LectureDto lectureDto) {
		String sql = "insert into lecture("
				+ "lecture_no, lecture_title, lecture_category, lecture_duration,"
				+ "lecture_price, lecture_type) "
				+ "values("
				+ "lecture_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] params = {
				lectureDto.getLectureTitle(), lectureDto.getLectureCategory(),
				lectureDto.getLectureDuration(), lectureDto.getLecturePrice(),
				lectureDto.getLectureType()
		};
		jdbcTemplate.update(sql, params);
	}
	public boolean update(LectureDto lectureDto) {
		String sql = "update lecture "
				+ "set lecture_title = ?, lecture_category=?, lecture_duration=?, "
				+ "lecture_price=?, lecture_type=? "
				+ "where lecture_no=?";
		Object[] params = {
				lectureDto.getLectureTitle(), lectureDto.getLectureCategory(), 
				lectureDto.getLectureDuration(), lectureDto.getLecturePrice(), 
				lectureDto.getLectureType(), lectureDto.getLectureNo()
		};
		return jdbcTemplate.update(sql, params) >0 ;
	}
	public boolean delete(int lectureNo) {
		String sql = "delete lecture where lecture_no = ?";
		Object[] params = {lectureNo};
		return jdbcTemplate.update(sql, params)>0;
	}
	public List<LectureDto> selectList(){
		String sql = "select * from lecture order by lecture_no asc";
		return jdbcTemplate.query(sql, lectureMapper);
	}
	
	public List<LectureDto> selectList(String column, String keyword){
		
		if(column == null || keyword == null) return selectList();
		Set<String> allowList = Set.of("lecture_title", "lecture_category", "lecture_type");
		if(allowList.contains(column) == false) return selectList();
		String sql = "select * from lecture where instr("+column+", ?)>0 order by lecture_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, lectureMapper, params);
	}
	public LectureDto selectOne(int lectureNo) {
		String sql = "select * from lecture where lecture_no =?";
		Object[] params = {lectureNo};
		List<LectureDto> list = jdbcTemplate.query(sql, lectureMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}


}

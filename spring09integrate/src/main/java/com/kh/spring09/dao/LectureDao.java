package com.kh.spring09.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.CountryDto;
import com.kh.spring09.dto.LectureDto;
import com.kh.spring09.mapper.LectureMapper;
import com.kh.spring09.vo.PageVO;




@Repository
public class LectureDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private LectureMapper lectureMapper;
	private Set<String> allowColumns = Set.of(
			"lecture_title", "lecture_category", "lecture_type"
			);
	
	public int sequence() {
		String sql = "select lecture_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	public void insert(LectureDto lectureDto) {
		String sql = "insert into lecture("
				+ "lecture_no, lecture_title, lecture_category, lecture_duration,"
				+ "lecture_price, lecture_type) "
				+ "values("
				+ "?, ?, ?, ?, ?, ?)";
		Object[] params = {lectureDto.getLectureNo(), 
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
	public List<LectureDto> selectList(int page, int size){
		String sql = "select * from ( "
							+ "select rownum rn, TMP.* from( "
									+ "select * from lecture order by lecture_no desc "
							+ ")TMP "
						+ ")where rn between ? and ?";
		int beginRow = page*size - (size-1);
		int endRow = page*size;
		Object[] params = {beginRow, endRow};
		
//		select * from (
//				select rownum rn, TMP.* from(
//						내가 원하는 데이터 조회 구문
//						)TMP
//				)where rn between ? and ?
		return jdbcTemplate.query(sql, lectureMapper, params);
	}
	public List<LectureDto> selectList(PageVO pageVO){
		if(pageVO.isList())
			return selectList(pageVO.getPage(), pageVO.getSize());
		
		if(!allowColumns.contains(pageVO.getColumn())) 
			return selectList(pageVO.getPage(), pageVO.getSize());
		
		String sql = "select * from ( "
				+ "select rownum rn, TMP.* from( "
				+ "select * from lecture "
				+ "where instr("+pageVO.getColumn()+", ?) >0 order by lecture_no desc"
						+ ")TMP "
						+ ")where rn between ? and ?";
//		int beginRow = page*size - (size-1);
//		int endRow = page*size;
		Object[] params = {pageVO.getKeyword(), 
								pageVO.getBeginRownum(), 
								pageVO.getEndRownum()};
		return jdbcTemplate.query(sql, lectureMapper, params);
	}
	public LectureDto selectOne(int lectureNo) {
		String sql = "select * from lecture where lecture_no =?";
		Object[] params = {lectureNo};
		List<LectureDto> list = jdbcTemplate.query(sql, lectureMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
	public int count() {
		String sql= "select count(*) from lecture";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public int count(String column, String keyword) {
		if(column == null || keyword == null) return count();
		
		String sql = "select count(*) from lecture where instr("+column+", ?) >0 ";
		Object[] params = {keyword};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
	public int count(PageVO pageVO) {
		if(pageVO.isList()) return count();
		
		String sql = "select count(*) from lecture where instr("+pageVO.getColumn()+", ?) >0 ";
		Object[] params = {pageVO.getKeyword()};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
	public void connect(int lectureNo, int attachNo) {
	String sql = "insert into lecture_image(lecture_no, attach_no"
						+ ") values(?, ?)";
	Object[] params = {lectureNo, attachNo};
	jdbcTemplate.update(sql, params);
	}
	public List<Integer> searchImage(int lectureNo) {
		String sql = "select attach_no from lecture_image "
					+ "where lecture_no =?";
		Object[] params = {lectureNo};
		return jdbcTemplate.queryForList(sql, int.class, params);
	}
	

}

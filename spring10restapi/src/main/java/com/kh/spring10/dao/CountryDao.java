package com.kh.spring10.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.CountryDto;
import com.kh.spring10.mapper.CountryMapper;
import com.kh.spring10.vo.PageVO;

@Repository//DB나 파일을 제어하기 위한 도구(영속성을 가진 대상 제어 도구)
public class CountryDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private CountryMapper countryMapper;
	private Set<String> allowColumns = Set.of(
			"country_region", "country_name", "country_capital"
			);
	
	
	//필요한 기능을 메소드로 구현
	public int sequence() {
		String sql = "select country_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	public void insert(CountryDto countryDto) {
		String sql = "insert into country("
				+ "country_no, country_region, country_name, "
				+ "country_capital, country_population"
				+ ") values(?, ?, ?, ?, ?)";
		Object[] params = {countryDto.getCountryNo(), 
				countryDto.getCountryRegion(), countryDto.getCountryName(),
				countryDto.getCountryCapital(), countryDto.getCountryPopulation()
		};
		jdbcTemplate.update(sql, params);
		
	}
	//수정메소드
	public boolean update(CountryDto countryDto) {
		String sql = "update country "
				+ "		set country_region=?, country_name=?, "
				+ "		country_capital=?, country_population=? "
				+ "		where country_no=? ";
		Object[] params = {
				countryDto.getCountryRegion(), 
				countryDto.getCountryName(), 
				countryDto.getCountryCapital(), 
				countryDto.getCountryPopulation(), 
				countryDto.getCountryNo()
		};
		int rows = jdbcTemplate.update(sql, params);
		return rows > 0; //한줄로 표현 
	}
	
	public boolean delete(int countryNo) {
		String sql = "delete country where country_no=?";
		Object[] params = {countryNo};
		return jdbcTemplate.update(sql, params) >0;
		
	}
	//조회, 검색 메소드
	public List<CountryDto> selectList(){
		String sql = "select * from country order by country_no asc";
		return jdbcTemplate.query(sql, countryMapper);
	}
	
	public List<CountryDto> selectList(String column, String keyword){
		if(column == null || keyword == null) return selectList(); //검색항목이 없으면 비어있는 결과반환 
		
		Set<String> allowList = Set.of("country_region", "country_name", "country_capital");
		if(allowList.contains(column) == false) return List.of();//허용되는 검색항목이 아니면 비어있는 결과 반환
		
		String sql = "select * from country where instr("+column+", ?) >0 order by country_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, countryMapper, params);//(주의)홀더는 맨 마지막!!!! 
	}
	public List<CountryDto> selectList(int beginRownum, int endRownum){
		String sql = "select * from ( "
							+ "select rownum rn, TMP.* from( "
									+ "select * from country order by country_no desc "
							+ ")TMP "
						+ ")where rn between ? and ?";
//		int beginRow = page*size - (size-1);
//		int endRow = page*size;
		Object[] params = {beginRownum, endRownum};
		
//		select * from (
//				select rownum rn, TMP.* from(
//						내가 원하는 데이터 조회 구문
//						)TMP
//				)where rn between ? and ?
		return jdbcTemplate.query(sql, countryMapper, params);
	}
	public List<CountryDto> selectList(PageVO pageVO){
		if(pageVO.isList())
			return selectList(pageVO.getBeginRownum(), pageVO.getEndRownum());
		
		if(!allowColumns.contains(pageVO.getColumn())) 
			return List.of();
		
		String sql = "select * from ( "
				+ "select rownum rn, TMP.* from( "
				+ "select * from country "
				+ "where instr("+pageVO.getColumn()+", ?) >0 order by country_no desc"
						+ ")TMP "
						+ ")where rn between ? and ?";
//		int beginRow = page*size - (size-1);
//		int endRow = page*size;
		Object[] params = {pageVO.getKeyword(), 
								pageVO.getBeginRownum(), 
								pageVO.getEndRownum()};
		return jdbcTemplate.query(sql, countryMapper, params);
	}
	
	public CountryDto selectOne(int countryNo) {
		String sql = "select * from country where country_no= ?";
		Object[] params = {countryNo};
		List<CountryDto> list = jdbcTemplate.query(sql, countryMapper, params); //일단 목록으로조회하고 
		return list.isEmpty() ? null : list.get(0);
	}
	public int count() {
		String sql= "select count(*) from country";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public int count(String column, String keyword) {
		if(column == null || keyword == null) return count();
		
		String sql = "select count(*) from country where instr("+column+", ?) >0 ";
		Object[] params = {keyword};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
	public int count(PageVO pageVO) {
		if(pageVO.isList()) return count();
		
		Set<String> allowList = Set.of("country_region", "country_name", "country_capital");
		if(allowList.contains(pageVO.getColumn()) == false) return 0;
		
		String sql = "select count(*) from country where instr("+pageVO.getColumn()+", ?) >0 ";
		Object[] params = {pageVO.getKeyword()};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
	//국기 등록
	public void connect(int countryNo, int attachNo) {
	String sql = "insert into country_flag(country_no, attach_no) values(?, ?)";
	Object[] params = {countryNo, attachNo};
	jdbcTemplate.update(sql, params);
	}
	
	//국기 탐색
	public int searchFlag(int countryNo) {
		String sql = "select attach_no from country_flag where country_no=?";
		Object[] params = {countryNo};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
	

	//RESP API용 페이징 메소드
	//- 동일 데이터가 두번 나오지 않도록 번호로 필터링하여 10개를 추출
	public List<CountryDto> selectListFroReact(int lastCountryNo, int size){
		String sql = "select * from ("
						+ "select rownum rn, TMP.* from("
							+ "select * from country"
							+ "where country_no > ?"
							+ "order by country_no asc"
							+ ")TMP"
						+ ") where rn between 1 and ?";
		Object[] params = { lastCountryNo, size};
		return jdbcTemplate.query(sql, countryMapper, params);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

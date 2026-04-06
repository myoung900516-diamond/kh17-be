package com.kh.spring06.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.CountryDto;
import com.kh.spring06.mapper.CountryMapper;

@Repository//DB나 파일을 제어하기 위한 도구(영속성을 가진 대상 제어 도구)
public class CountryDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private CountryMapper countryMapper;
	
	//필요한 기능을 메소드로 구현
	
	public void insert(CountryDto countryDto) {
		String sql = "insert into country("
				+ "country_no, country_region, country_name, "
				+ "country_capital, country_population"
				+ ") values(country_seq.nextval, ?, ?, ?, ?)";
		Object[] params = {
				countryDto.getCountryRegion(), countryDto.getCountryName(),
				countryDto.getCountryCapital(), countryDto.getCountryPopulation()
		};
		jdbcTemplate.update(sql, params);
		
	}
	//수정메소드
	public boolean update(CountryDto countryDto) {
		String sql = "update country "
				+ "		set country_region=?, country_name=? "
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
	
	public CountryDto selectOne(int countryNo) {
		String sql = "select * from country where country_no= ?";
		Object[] params = {countryNo};
		List<CountryDto> list = jdbcTemplate.query(sql, countryMapper, params); //일단 목록으로조회하고 
		return list.isEmpty() ? null : list.get(0);
	}
	
	

}

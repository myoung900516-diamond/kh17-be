package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.CountryDto;
import jdbc.util.JdbcUtils;

//DAO(Data Access Object)
//-데이터에 접근하는 작업을 수행하는 객체
//-DB전담 클래스 (테이블마다 생성)
//-등록,수정,삭제,조회 등 자주 사용되는 DB작업들을 메소드로 보관 

public class CountryDao {
	
	//내가 일을 하려면 메소드가 필요
	//-등록메소드를 만들거에요. 
	//-등록 메소드 : [대륙, 국가명,수도명,인구수]를 받아서 DB등록 후 반환값은 없음
	//public 반환형 void 이름(매개변수) {}
	//매개변수가 뭔지 모르면 입력 다 지워서 에러나는 곳
	//처리부분 다 지워서 출력이 에러 안나면 void
	//public void insert(String countryRegion, String countryName,
	//		String countryCapital, long countryPopulation) {
	public void insert(CountryDto countryDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		
		String sql = "insert into country(country_no, country_region, country_name, "
				+ "country_capital, country_population)"
				+ "values("
				+ "country_seq.nextval, ?, ?, ?, ?)";
//		Object[] params =  {countryRegion, countryName, 
//				countryCapital, countryPopulation};
		Object[] params =  {countryDto.getCountryRegion(), countryDto.getCountryName(),
									countryDto.getCountryCapital(), countryDto.getCountryPopulation()};
		jdbcTemplate.update(sql, params);
		
	} 
	
}


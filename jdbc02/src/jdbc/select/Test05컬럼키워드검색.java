package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test05컬럼키워드검색 {
	public static void main(String[] args) {
		//입력
		//-[ 국가명■ ] [시아    ][검색]  과 같은 상황을 구현하고자함 
		String column = "country_region";
		String keyword = "시아";
		
		//처리
		//- column은 구문에 들어갈 값이고, keyword는 데이터로 배치될 값이다. 
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
//		String sql = "select * from country where instr(항목, 키워드) >0 order by country_no asc";
//		String sql = "select * from country where instr(?, ?) >0 order by country_no asc";
		String sql = "select * from country where instr("+column+", ?) >0 order by country_no asc";
		Object[] params = {keyword} ;
		CountryMapper countryMapper = new CountryMapper();
		List<CountryDto> list = jdbcTemplate.query(sql, countryMapper, params);
		
		
		
		//출력
		System.out.println(sql);
		System.out.println(list.size());
		for(CountryDto countryDto : list) {
			System.out.println(countryDto);
		}
		
		
		
		
		
	}
}

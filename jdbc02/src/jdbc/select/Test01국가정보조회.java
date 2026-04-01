package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.CountryDto;
import jdbc.mapper.CountryMapper;
import jdbc.util.JdbcUtils;

public class Test01국가정보조회 {
	public static void main(String[] args) {
		//국가 정보 조회
		
		JdbcTemplate jdbcTemplate =JdbcUtils.create();
		String sql = "select * from country order by country_no asc";
		//Object[] params =={};
		//jdbcTemplate.update(sql)//실행은 되지만 적합하지 않은 명령 
		
		//조회된 결과(ResultSet)의 행(Row)을 연결(Mapping)시키는 도구 
		//RowMapper<CountryDto> mapper = new RowMapper<>(); 
		CountryMapper countryMapper = new CountryMapper();//내가 준비한 반환도구 생성
		List<CountryDto> list = jdbcTemplate.query(sql, countryMapper);
		
//		System.out.println("조회완료");
		System.out.println("조회결과: " + list.size() + "개");
		for(CountryDto countryDto : list) {
			System.out.println(countryDto);
		}
	}
}

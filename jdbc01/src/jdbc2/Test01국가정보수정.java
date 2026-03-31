package jdbc2;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.JdbcUtils;

public class Test01국가정보수정 {
	public static void main(String[] args) {
		//특정 국가에 설정된 정보를 변경 
		
		
		//입력
		int countryNo = 1;
		String countryRegion = "오세아니아";
		String countryName = "호주";
		String countryCapital = "캔버라";
		long countryPopulation = 280000000L;
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "update country "
				+ "set country_region = ?, country_name=?, "
				+ "country_capital=?, country_population=? "
				+ "where country_no = ?";
		Object[] params = {
				countryRegion, countryName, countryCapital, countryPopulation, countryNo
		};
		int rows = jdbcTemplate.update(sql, params);
		
		//출력
		if(rows >0 ) {			
			System.out.println("국가 정보가 변경되었습니다");
		}
		else {
			System.out.println("해당 번호의 국가가 존재하지 않습니다");
		}
		
	}

}

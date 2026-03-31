package jdbc;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02국가정보등록2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("대륙이름, 국가명, 수도, 인구정보를 입력하세요");
		String countryRegion = sc.nextLine();
//		sc.nextLine();
		String countryName = sc.nextLine();
//		sc.nextLine();
		String countryCapital = sc.nextLine();
		long countryPopulation = sc.nextLong();
		sc.close();
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();//연결도구
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");//DB의 종류를 알려줌
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");//DB의 위치와 연결정보
		dataSource.setUsername("kh17");//계정이름
		dataSource.setPassword("kh17");//비밀번호
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();//실행도구
		jdbcTemplate.setDataSource(dataSource);//연결정보를 건네준다(=경찰에게 총을 준다와 비슷)
		

				
		String sql = "insert into country(country_no, country_region, country_name, "
				+ "country_capital, country_population)"
				+ "values("
				+ "country_seq.nextval, ?, ?, ?, ?)";
		//Object[] params = new Object[] {countryRegion, countryName, 
		//		countryCapital, countryPopulation};
		Object[] params =  {countryRegion, countryName, 
						countryCapital, countryPopulation};
		
		//최종형태(동적SQL방식)
		//-데이터가 들어갈 부분을 홀더(?)로 표기
		//-홀더에 들어갈 데이터를 Object[]로 순서대로 배치하여 전달 
		
		jdbcTemplate.update(sql, params);//구문이랑 데이터 줄게요 알아서 하세요. 
		
		
		System.out.println("실행완료");
}
}
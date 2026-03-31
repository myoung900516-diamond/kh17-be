package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test01연결테스트 {
	public static void main(String[] args) {
		//연결이 가능한지 테스트 수행
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh17");
		dataSource.setPassword("kh17");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		//String sql = "select count(*) from item";
		//String sql = "delete item";
		String sql = "rollback";
		jdbcTemplate.execute(sql);//실행
		
		
		
		System.out.println("실행완료");
	}

}

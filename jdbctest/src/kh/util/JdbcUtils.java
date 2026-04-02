package kh.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcUtils {
//-s가 붙으면 도우미 클래스 
	//DB 명령 실행에 사용할 JdbcTemplate을 생성하는 메소드 
	public static JdbcTemplate create() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh17");
		dataSource.setPassword("kh17");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		return jdbcTemplate;
		//자주쓰는건 쓰기 귀찮으니까 메소드로 만든다구
		
	}
}

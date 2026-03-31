package jdbc;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02국가정보등록 {
	public static void main(String[] args) {
		//연결이 가능한지 테스트 수행
		DriverManagerDataSource dataSource = new DriverManagerDataSource();//연결도구
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");//DB의 종류를 알려줌
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");//DB의 위치와 연결정보
		dataSource.setUsername("kh17");//계정이름
		dataSource.setPassword("kh17");//비밀번호
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();//실행도구
		jdbcTemplate.setDataSource(dataSource);//연결정보를 건네준다(=경찰에게 총을 준다와 비슷)
		
//		String sql = "create table country("
//							+ "country_no number primary key,"
//							+ "country_region varchar(60byte) not null,"
//							+ "country_";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("대륙이름, 국가명, 수도, 인구정보를 입력하세요");
		String region = sc.next();
//		sc.nextLine();
		String name = sc.next();
//		sc.nextLine();
		String capital = sc.next();
		long population = sc.nextLong();
		sc.close();
//		
//		String sql = "delete country";
//		String sql = "insert into country(country_no, country_region, country_name, "
//				+ "country_capital, country_population)"
//				+ "values(country_seq.nextval, '아시아', '대한민국', '서울', 50000000)";
						
		String sql = "insert into country(country_no, country_region, country_name, "
				+ "country_capital, country_population)"
				+ "values("
				+ "country_seq.nextval, '"+region+"', '"+name+"', "
						+ "'"+capital+"', "+population+")";
		
		jdbcTemplate.execute(sql);//실행
		
		
		System.out.println("실행완료");
}
}
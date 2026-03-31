package jdbc;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test03강좌정보등록 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("강좌이름 = ");
		String lectureTitle = sc.nextLine();
		System.out.println("카테고리 = ");
		String lectureCategory = sc.nextLine();
		System.out.println("강좌기간 = "); 
		int lectureDuration = sc.nextInt();
		System.out.println("강좌료 = ");
		int lecturePrice = sc.nextInt();
		System.out.println("강좌형태");
		String lectureType = sc.next();
//		sc.next();
		
		sc.close();
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh17");
		dataSource.setPassword("kh17");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
//		String lectureTitle = "코딩이론";
//		String lectureCategory = "이론";
//		int lectureDuration = 60;
//		int lecturePrice = 250000;
//		String lectureType = "오프라인";
		
//		String sql = "insert into lecture(lecture_no, lecture_title, lecture_category, "
//				+ "lecture_duration, lecture_price, lecture_type)"
//				+ "values(lecture_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] params = {lectureTitle, lectureCategory, lectureDuration, lecturePrice, 
				lectureType};
		String sql = "update lecture set lecture_duration = 990"
				+ " where lecture_title = '코딩기초'";
//		jdbcTemplate.update(sql, params);
		jdbcTemplate.update(sql);
		
		System.out.println("등록완료");
		
	}

}

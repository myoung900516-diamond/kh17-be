package jdbc.delete;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test03도서정보삭제 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("강좌 번호를 입력하세요");
		int lectureNo = sc.nextInt();
		sc.close();
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "delete lecture where lecture_no = ?";
		Object[] params = {lectureNo};
		int rows = jdbcTemplate.update(sql, params);
		
		//출력
		if(rows > 0) {
			System.out.println("강좌 정보 삭제 완료");
		}
		else {
			System.out.println("등록되지 않은 강좌입니다");
		}
		
	}

}

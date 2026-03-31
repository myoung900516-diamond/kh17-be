package jdbc2;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.JdbcUtils;

public class Test02강좌정보수정 {
	public static void main(String[] args) {
		
		//입력
		int lectureNo = 1;
		String lectureTitle = "바꾼이름";
		String lectureCategory = "이론";
		String lectureType = "혼합";
		int lectureDuration = 90;
		int lecturePrice = 10000;
		
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		//처리
		String sql ="update lecture "
				+ "set lecture_title = ?, lecture_category = ?, lecture_duration = ?, "
				+ "lecture_price = ?, lecture_type = ? "
				+ "where lecture_no = ?";
		Object[] params = {
				lectureTitle, lectureCategory, lectureDuration, 
				lecturePrice, lectureType, lectureNo 
		};
		int rows = jdbcTemplate.update(sql, params);
		
		
		//출력
		if(rows > 0) {
			System.out.println("등록완료");
		}
		else {
			System.out.println("등록실패");
		}
	}

}

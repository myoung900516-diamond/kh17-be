package jdbc.delete;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test01국가정보삭제 {
	public static void main(String[] args) {
		//[SQL]delete country where country_no = ?;
		
		//입력
		int countryNo =62;
		
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcUtils.create();//처리도구생성
		String sql = "delete country where country_no = ?";//미완성 구문
		
		Object[] params = {countryNo};//구문의 홀더에 들어갈 데이터
		int rows = jdbcTemplate.update(sql, params);//정보 제공하며 실행 지시 
		
		//출력
		if(rows > 0) {
			System.out.println("삭제가 완료되었습니다");
		}
		else {
			System.out.println("존재하지 않는 국가 번호입니다");
		}
		
	}

}

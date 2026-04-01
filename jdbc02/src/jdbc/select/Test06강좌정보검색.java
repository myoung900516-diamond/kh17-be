package jdbc.select;

import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.LectureDto;
import jdbc.mapper.LectureMapper;
import jdbc.util.JdbcUtils;

public class Test06강좌정보검색 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("검색항목 : ");
		String column = sc.nextLine();
		System.out.println("검색키워드 : ");
		String keyword = sc.nextLine();
//		String column = "lecture_title";
//		String keyword = "기사";
		sc.close();
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
//		String sql = "select * from lecture where instr("+column+", ?) > 0 order by lecture_no asc";
		String sql = "select * from lecture where "+column+" like ? order by lecture_no asc";
//		String sql = "select * from lecture where "+column+" like ?||'%' order by lecture_no asc";
		String sql2 = "select * from lecture order by lecture_no asc";
//		Object[] params = {keyword};
		Object[] params = {keyword+"%"};
		LectureMapper lectureMapper = new LectureMapper();
		List<LectureDto> list = jdbcTemplate.query(sql, lectureMapper, params);
		List<LectureDto> list2 = jdbcTemplate.query(sql2, lectureMapper);
		//출력
		if(list.size() == 0) { //=if(list.isEmpty(){
			for(LectureDto lectureDto2 : list2) {
				System.out.println(lectureDto2);
			}
		}
		else {
			for(LectureDto lectureDto : list) {
				System.out.println(lectureDto);
			}
		}
		
	}

}

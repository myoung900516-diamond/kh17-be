package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test03도서정보조회 {
	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
//		String sql = "select * from book order by book_id asc";
//		String sql = "select * from book where book_id = 2";
		String sql = "select * from book where book_price >= 20000";
//		Object [] params = {};
		BookMapper bookMapper = new BookMapper();
//		List<BookDto> list = jdbcTemplate.query(sql, bookMapper, params);
		List<BookDto> list = jdbcTemplate.query(sql, bookMapper);
		
		for(BookDto bookDto : list) {
			System.out.println(bookDto);
			
		}                                                      
	}

}

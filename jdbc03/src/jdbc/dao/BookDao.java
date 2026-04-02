package jdbc.dao;

import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BookDto;
import jdbc.mapper.BookMapper;
import jdbc.util.JdbcUtils;

public class BookDao {
	public void insert(BookDto bookDto){
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		
		String sql = "insert into book("
				+ "book_id, book_title, book_author, book_publication_date, "
				+ "book_price, book_publisher, book_page_count, book_genre"
				+ ")"
				+ "values(book_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] params = {
			bookDto.getBookTitle(), bookDto.getBookAuthor(), bookDto.getBookPublicationDate(),
			bookDto.getBookPrice(), bookDto.getBookPublisher(), bookDto.getBookPageCount(), 
			bookDto.getBookGenre()};
		jdbcTemplate.update(sql, params);
		
	}
	public boolean update(BookDto bookDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "update book "
				+ "set book_title=?, book_author=?, book_publication_date=?,"
				+ "book_price=?, book_publisher=?, book_page_count=?, book_genre=? "
				+ "where book_id=?";
		Object[] params = {
				bookDto.getBookTitle(), bookDto.getBookAuthor(), bookDto.getBookPublicationDate(),
				bookDto.getBookPrice(), bookDto.getBookPublisher(), bookDto.getBookPageCount(),
				bookDto.getBookGenre(), bookDto.getBookId()
		};
		int rows = jdbcTemplate.update(sql, params);
		
		return rows > 0;
	}
	public boolean delete(int bookId) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "delete book where book_id=?";
		Object[] params = {bookId};
		return jdbcTemplate.update(sql, params)>0 ;
		
	}
	
	public List<BookDto> selectList(){
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from book order by book_id asc";
		BookMapper bookMapper = new BookMapper();
		return jdbcTemplate.query(sql, bookMapper);
	}
	
	public List<BookDto> selectList(String column, String keyword){
		
		if(column == null || keyword == null) return selectList();//없는 경우를 처리하고 싶다면(필수)
		if(column.isEmpty() || keyword.isEmpty()) return selectList(); //빈 문자열을 처리하고 싶다면(선택)
		
		Set<String> allowList =Set.of("book_title", "book_author", "book_publisher", "book_genre");
		if(allowList.contains(column) == false) return selectList();
		
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from book where instr("+column+", ?) >0 order by book_id asc";
		Object[] params = {keyword};
		BookMapper bookMapper = new BookMapper();
		return jdbcTemplate.query(sql, bookMapper, params);
		
	}
	public BookDto selectOne(int bookId) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from book where book_id = ? ";
		Object[] params = {bookId};
		BookMapper bookMapper = new BookMapper();
		List<BookDto> list = jdbcTemplate.query(sql, bookMapper, params);
		return list.isEmpty() ? null : list.get(0);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

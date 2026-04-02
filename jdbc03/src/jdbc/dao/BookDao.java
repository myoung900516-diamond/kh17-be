package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BookDto;
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

}

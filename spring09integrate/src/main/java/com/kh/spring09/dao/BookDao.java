package com.kh.spring09.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.dto.BookDto;
import com.kh.spring09.mapper.BookMapper;
import com.kh.spring09.vo.PageVO;

@Repository
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BookMapper bookMapper;
	private Set<String> allowColumns = Set.of(
			"book_title", "book_author", "book_publication_date", 
			"book_publisher", "book_genre"
			);
	
	public int sequence() {
		String sql = "select book_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert(BookDto bookDto){
		
		String sql = "insert into book("
				+ "book_id, book_title, book_author, book_publication_date, "
				+ "book_price, book_publisher, book_page_count, book_genre"
				+ ")"
				+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] params = {bookDto.getBookId(), 
			bookDto.getBookTitle(), bookDto.getBookAuthor(), bookDto.getBookPublicationDate(),
			bookDto.getBookPrice(), bookDto.getBookPublisher(), bookDto.getBookPageCount(), 
			bookDto.getBookGenre()};
		jdbcTemplate.update(sql, params);
		
	}
	public boolean update(BookDto bookDto) {
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
		String sql = "delete book where book_id=?";
		Object[] params = {bookId};
		return jdbcTemplate.update(sql, params)>0 ;
	}
	
	public List<BookDto> selectList(){
		String sql = "select * from book order by book_id asc";
		return jdbcTemplate.query(sql, bookMapper);
	}
	
	public List<BookDto> selectList(String column, String keyword){
		
		if(column == null || keyword == null) return selectList();
		if(column.isEmpty() || keyword.isEmpty()) return selectList(); 
		
		Set<String> allowList =Set.of(
				"book_title", "book_author", "book_publication_date", 
				"book_publisher", "book_genre"
				);
		if(allowList.contains(column) == false) return selectList();
		
		String sql = "select * from book where instr("+column+", ?) >0 order by book_id asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, bookMapper, params);
		
	}
	
	public List<BookDto> selectList(int page, int size){
		String sql = "select * from ( "
							+ "select rownum rn, TMP.* from( "
									+ "select * from book order by book_id desc "
							+ ")TMP "
						+ ")where rn between ? and ?";
		int beginRow = page*size - (size-1);
		int endRow = page*size;
		Object[] params = {beginRow, endRow};
		

		return jdbcTemplate.query(sql, bookMapper, params);
	}
			
	

	public List<BookDto> selectList(PageVO pageVO){
		if(pageVO.isList())
			return selectList(pageVO.getPage(), pageVO.getSize());
		
		if(!allowColumns.contains(pageVO.getColumn())) 
			return selectList(pageVO.getPage(), pageVO.getSize());
		
		String sql = "select * from ( "
				+ "select rownum rn, TMP.* from( "
				+ "select * from book "
				+ "where instr("+pageVO.getColumn()+", ?) >0 order by book_id desc"
						+ ")TMP "
						+ ")where rn between ? and ?";

		Object[] params = {pageVO.getKeyword(), 
								pageVO.getBeginRownum(), 
								pageVO.getEndRownum()};
		return jdbcTemplate.query(sql, bookMapper, params);
	}
	
	public BookDto selectOne(int bookId) {
		String sql = "select * from book where book_id = ? ";
		Object[] params = {bookId};
		List<BookDto> list = jdbcTemplate.query(sql, bookMapper, params);
		return list.isEmpty() ? null : list.get(0);
		
	}
	public int count() {
		String sql= "select count(*) from book";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public int count(PageVO pageVO) {
		if(pageVO.isList()) return count();
		if(!allowColumns.contains(pageVO.getColumn())) return count();
		
		String sql = "select count(*) from book where instr("+pageVO.getColumn()+", ?) >0 ";
		Object[] params = {pageVO.getKeyword()};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
	public void connect(int bookId, int attachNo) {
		String sql = "insert into book_cover(book_id, attach_no) values(?, ?)";
		Object[] params = {bookId, attachNo};
		jdbcTemplate.update(sql, params);
	}
	public int searchCover(int bookId) {
		String sql = "select attach_no from book_cover where book_id = ?";
		Object[] params = {bookId};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
	
	

}

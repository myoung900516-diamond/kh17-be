package jdbc2;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.JdbcUtils;

public class Test03도서정보수정 {
	public static void main(String[] args) {
		
		
		//입력
		int bookId = 1;
		String bookTitle = "바꾼도서명";
		String bookAuthor = "바꾼저자";
		String bookPublicationDate = "2026-03-01";
		int bookPrice = 10000;
		int bookPageCount = 100;
		String bookPublisher = "바꾼출판사";
		String bookGenre = "자기계발";
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql ="update book "
				+ "set book_title=?, book_author=?, book_publication_date=?, "
				+ "book_price=?, book_page_count=?, book_publisher=?, book_genre=? "
				+ "where book_id= ?";
		Object[] params = {
				bookTitle, bookAuthor, bookPublicationDate, bookPrice,
				bookPageCount, bookPublisher, bookGenre, bookId
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

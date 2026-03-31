package jdbc;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

public class Test04도서정보등록 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("booktitle : ");
		String bookTitle = sc.nextLine();
		System.out.println("bookauthor : ");
		String bookAuthor = sc.nextLine();
		System.out.println("bookpublicationdate : ");
		String bookPublicationDate = sc.nextLine();
		System.out.println("bookprice : ");
		int bookPrice = sc.nextInt();
		System.out.println("bookpublisher : ");
		String bookPublisher = sc.next();
		System.out.println("bookpage : "); 
		int bookPageCount = sc.nextInt();
		System.out.println("bookgenre : ");
		String bookGenre = sc.next();
		
		sc.close();
		
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		
		String sql = "insert into book("
				+ "book_id, book_title, book_author, book_publication_date, "
				+ "book_price, book_publisher, book_page_count, book_genre"
				+ ")"
				+ "values(book_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] params = {
			bookTitle, bookAuthor, bookPublicationDate,
			bookPrice, bookPublisher, bookPageCount, bookGenre
			};
		jdbcTemplate.update(sql, params);
		System.out.println("등록완료!");
	}

}

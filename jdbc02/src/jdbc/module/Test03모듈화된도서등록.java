package jdbc.module;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test03모듈화된도서등록 {
	public static void main(String[] args) {
		BookDto bookDto = new BookDto();
		bookDto.setBookTitle("젊은베르테르의슬픔");
		bookDto.setBookAuthor("괴테");
		bookDto.setBookPublicationDate("1774-06-25");
		bookDto.setBookPrice(23000);
		bookDto.setBookPublisher("열린책들");
		bookDto.setBookGenre("소설");
		
		BookDao bookDao = new BookDao();
		bookDao.insert(bookDto);
		
		System.out.println("complete");
	}


}

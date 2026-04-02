package jdbc.program;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test03모듈화된도서정보수정 {
	public static void main(String[] args) {
		BookDto bookDto = new BookDto();
		bookDto.setBookId(0);
		bookDto.setBookTitle(null);
		bookDto.setBookAuthor(null);
		bookDto.setBookPublicationDate(null);
		bookDto.setBookPrice(0);
		bookDto.setBookPublisher(null);
		bookDto.setBookPageCount(0);
		bookDto.setBookGenre(null);
		
		BookDao bookDao = new BookDao();
		boolean success = bookDao.update(bookDto);
		
		if(success) {
			System.out.println("도서수정완료");
		}
		else {
			System.out.println("대상이 존재하지 않습니다");
		}
	}

}

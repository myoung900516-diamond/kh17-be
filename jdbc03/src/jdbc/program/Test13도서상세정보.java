package jdbc.program;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test13도서상세정보 {
	public static void main(String[] args) {
		int bookId = 3;
		
		BookDao bookDao = new BookDao();
		BookDto bookDto = bookDao.selectOne(bookId);
		
		System.out.println(bookDto);
	}

}

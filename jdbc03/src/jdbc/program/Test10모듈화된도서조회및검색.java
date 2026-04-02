package jdbc.program;

import java.util.List;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test10모듈화된도서조회및검색 {
	public static void main(String[] args) {
		String column ="";
		String keyword = "";
		
		BookDao bookDao = new BookDao();
		List<BookDto> list = bookDao.selectList(column, keyword);
		
		for(BookDto bookDto : list) {
			System.out.println(bookDto);
		}
	}

}

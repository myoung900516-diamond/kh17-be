package jdbc.program;

import jdbc.dao.BookDao;

public class Test06모듈화된도서정보삭제 {
	public static void main(String[] args) {
		int bookId = 2;
		
		BookDao bookDao = new BookDao();
		boolean success = bookDao.delete(bookId);
		
		if(success) {
			System.out.println("도서정보삭제완료");
		}
		else {
			System.out.println("대상이 존재하지 않습니다");
		}
		
	}

}

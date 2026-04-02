package jdbc.module;

import java.util.Scanner;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test03모듈화된도서등록 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookDto bookDto = new BookDto();
		System.out.println("도서이름 : ");
		bookDto.setBookTitle(sc.nextLine());
		System.out.println("저자이름 : ");
		bookDto.setBookAuthor(sc.nextLine());
		System.out.println("출간일 : ");
		bookDto.setBookPublicationDate(sc.nextLine());
		System.out.println("출판사 : ");
		bookDto.setBookPublisher(sc.nextLine());
		System.out.println("가격 : ");
		bookDto.setBookPrice(sc.nextInt());
		System.out.println("페이지수 : ");
		bookDto.setBookPageCount(sc.nextInt());
		System.out.println("장르 : ");
		sc.nextLine();
		bookDto.setBookGenre(sc.nextLine());
		sc.close();
		
		
//		BookDto bookDto = new BookDto();
//		bookDto.setBookTitle("젊은베르테르의슬픔");
//		bookDto.setBookAuthor("괴테");
//		bookDto.setBookPublicationDate("1774-06-25");
//		bookDto.setBookPrice(23000);
//		bookDto.setBookPublisher("열린책들");
//		bookDto.setBookPageCount(356);
//		bookDto.setBookGenre("소설");
		
		BookDao bookDao = new BookDao();
		bookDao.insert(bookDto);
		
		System.out.println("complete");
		
	}


}

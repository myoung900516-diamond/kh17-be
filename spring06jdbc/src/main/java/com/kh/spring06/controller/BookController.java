package com.kh.spring06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.BookDao;
import com.kh.spring06.dto.BookDto;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookDao bookDao;
	
	@RequestMapping("/insert")
	public String insert(BookDto bookDto) {
		bookDao.insert(bookDto);
		return "등록완료";
	}
	@RequestMapping("/update")
	public String update(BookDto bookDto) {
		boolean success = bookDao.update(bookDto);
		if(success) {
			return "수정완료";
		}
		else {
			return "등록되지 않은 도서입니다";
		}
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam int bookId) {
		boolean success = bookDao.delete(bookId);
		if(success) {
			return "삭제완료";
		}
		else {
			return "등록되지 않은 도서입니다";
		}
	}
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column, @RequestParam(required = false) String keyword) {
		List<BookDto> list = bookDao.selectList(column, keyword);
		StringBuffer buffer = new StringBuffer();
		buffer.append("도서 번호 : " + list.size() + "<br>");
		for(BookDto bookDto : list) {
			buffer.append(bookDto);
			buffer.append("<br>");
		}
		return buffer.toString();

	}
	@RequestMapping("/detail")
	public String detail(@RequestParam int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		StringBuffer buffer = new StringBuffer();
		buffer.append("도서번호 : " + bookDto.getBookId()+ "<br>");
		buffer.append("제목 : " + bookDto.getBookTitle()+ "<br>");
		buffer.append("저자 : " + bookDto.getBookAuthor()+ "<br>");
		buffer.append("출간일 : " + bookDto.getBookPublicationDate()+ "<br>");
		buffer.append("가격 : " + bookDto.getBookPrice()+ "<br>");
		buffer.append("출판사 : " + bookDto.getBookPublisher()+ "<br>");
		buffer.append("페이지수 : " + bookDto.getBookPageCount()+ "<br>");
		buffer.append("장르 : " + bookDto.getBookGenre()+ "<br>");
		return buffer.toString();
	}

}

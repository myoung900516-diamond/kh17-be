package com.kh.spring06.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.BookDao;
import com.kh.spring06.dto.BookDto;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookDao bookDao;
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute BookDto bookDto) {
		bookDao.insert(bookDto);
		return "등록완료";
	}
	@RequestMapping("/update")
	public String update(@ModelAttribute BookDto bookDto, 
			HttpServletResponse response) throws IOException {
		boolean success = bookDao.update(bookDto);
		if(!success) {
			response.sendRedirect("notFound");
			return null;
		}
		return "수정완료";
//		if(success) {
//			return "수정완료";
//		}
//		else {
//			//return "등록되지 않은 도서입니다";
//			response.sendRedirect("notFound");
//			return null;
//		}
	}
	//오류 메세지 매핑
	@RequestMapping("/notFound")
	public String notFound() {
		return "오류페이지로 연결되다니 신기하다";
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int bookId, 
			HttpServletResponse response) throws IOException {
		boolean success = bookDao.delete(bookId);
		if(!success) {
			response.sendRedirect("./notFound");
			return null;
		}
			return "삭제완료";
//		if(success) {
//			return "삭제완료";
//		}
//		else {
//			return "등록되지 않은 도서입니다";
//		}
	}
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column, 
			@RequestParam(required = false) String keyword) {
		List<BookDto> list = bookDao.selectList(column, keyword);
		StringBuffer buffer = new StringBuffer();
		buffer.append("도서 개수 : " + list.size() + "<br>");
		for(BookDto bookDto : list) {
			buffer.append(bookDto.toString());
			buffer.append("<br>");
		}
		return buffer.toString();

	}
	@RequestMapping("/detail")
	public String detail(@RequestParam int bookId, HttpServletResponse response) throws IOException {
		BookDto bookDto = bookDao.selectOne(bookId);
		
		if(bookDto == null) {
			response.sendRedirect("./notFound");
			return "존재하지 않는 국가 정보";
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("도서번호 : " + bookDto.getBookId()+ "<br>");
		buffer.append("제목 : " + bookDto.getBookTitle()+ "<br>");
		buffer.append("저자 : " + bookDto.getBookAuthorString()+ "<br>");
		buffer.append("출간일 : " + bookDto.getBookPublicationDateString()+ "<br>");
		buffer.append("가격 : " + bookDto.getBookPrice()+ "<br>");
		buffer.append("출판사 : " + bookDto.getBookPublisherString()+ "<br>");
		buffer.append("페이지수 : " + bookDto.getBookPageCount()+ "<br>");
		buffer.append("장르 : " + bookDto.getBookGenre()+ "<br>");
		return buffer.toString();
	}

}

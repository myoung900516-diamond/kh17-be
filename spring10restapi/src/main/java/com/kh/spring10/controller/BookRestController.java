package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.BookDao;
import com.kh.spring10.dto.BookDto;
import com.kh.spring10.dto.LectureDto;
import com.kh.spring10.vo.ListVO;

@CrossOrigin
@RestController
@RequestMapping("/api/book")
public class BookRestController {
	
	@Autowired
	private BookDao bookDao;
	
	@PostMapping("/insert")
	public void insert(@RequestBody BookDto bookDto) {
		int bookId = bookDao.sequence();
		bookDto.setBookId(bookId);
		bookDao.insert(bookDto);
	}
	//조회는 getmapping으로
	@GetMapping("/list")
	public List<BookDto> list(){
		return bookDao.selectList();
	}
	@GetMapping("/listForReact")
	public ListVO listForReact(
			@RequestParam(required = false, defaultValue= "0") int lastBookId, 
			@RequestParam(required = false, defaultValue= "10") int size
			){
		List list = bookDao.selectListFroReact(lastBookId, size);
		int count = bookDao.countForReact(lastBookId);
		
		return ListVO.builder()
					.list(list)
					.last(count <= size)
					.build();
	}
	
	@GetMapping("/detail")
	public BookDto detail(@RequestParam int bookId) {
		return bookDao.selectOne(bookId);
	}
	
	@GetMapping("/delete")
	public boolean delete(@RequestParam int bookId) {
		return bookDao.delete(bookId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

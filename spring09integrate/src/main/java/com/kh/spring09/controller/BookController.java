package com.kh.spring09.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.BookDao;
import com.kh.spring09.dto.BookDto;
import com.kh.spring09.exception.TargetNotfoundException;
import com.kh.spring09.service.AttachService;
import com.kh.spring09.vo.PageVO;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AttachService attachService;
	
	@GetMapping("/insert")
	public String insert() {
		return "book/insert";
	}
	@PostMapping("/insert")
	public String insert(@ModelAttribute BookDto bookDto, 
								@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		int bookId = bookDao.sequence();
		bookDto.setBookId(bookId);
		bookDao.insert(bookDto);
		
		if(!attach.isEmpty()) {
			int attachNo = attachService.save(attach);
			bookDao.connect(bookId, attachNo);
		}
		
		return "redirect:./insertComplete";
	}
	@RequestMapping("/insertComplete")
	public String insertComplete() {
		return "book/insertComplete";
	}
	@RequestMapping("/list")
	public String list(@ModelAttribute PageVO pageVO,
//							@RequestParam(required = false) String column, 
//							@RequestParam(required = false) String keyword,
			Model model) {
		List<BookDto> list = bookDao.selectList(pageVO);
		model.addAttribute("list", list);
		int count = bookDao.count(pageVO);
		pageVO.setCount(count);
		model.addAttribute("pageVO", pageVO);
		return "book/list";
	}
	@RequestMapping("/detail")
	public String detail(@RequestParam int bookId, Model model) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException("존재하지 않는 도서정보");
		model.addAttribute("bookDto", bookDto);
		return "book/detail";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException("존재하지 않는 도서정보");
		bookDao.delete(bookId);
		return "redirect:./list";
	}
	@GetMapping("/edit")
	public String edit(@RequestParam int bookId, Model model) {
		BookDto bookDto =bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException("존재하지 않는 도서 정보");
		model.addAttribute("bookDto", bookDto);
		return "book/edit";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BookDto bookDto) {
			bookDao.update(bookDto);
			return "redirect:./detail?bookId=" + bookDto.getBookId();
		
	}
	@RequestMapping("/cover")
	public String cover(@RequestParam int bookId) {
		try {
			//plan a - 이미지가 존재하는 경우
			int attachNo = bookDao.searchCover(bookId);
			return "redirect:/download/modern?attachNo=" + attachNo;
		}
		catch(Exception e ){
			//plan b - 이미지가 존재하지 않는 경우
			return "redirect:/images/noimgpng.png";
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

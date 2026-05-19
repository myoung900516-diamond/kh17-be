package com.kh.spring09.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.ReplyDao;
import com.kh.spring09.dto.ReplyDto;

import jakarta.servlet.http.HttpSession;

//@CrossOrigin
@RestController
@RequestMapping("/rest/reply")
public class ReplyRestController {
	@Autowired
	private ReplyDao replyDao;


	/*
	 * @RequestMapping("/write") public String replyWrite(@ModelAttribute ReplyDto
	 * replyDto, HttpSession session,
	 * 
	 * @RequestParam long boardNo) { String loginId =
	 * (String)session.getAttribute("loginId");
	 * 
	 * replyDto.setReplyWriter(loginId); replyDto.setReplyOrigin(boardNo);
	 * 
	 * replyDao.insert(replyDto);
	 * 
	 * return "redirect:/board/detail?boardNo="+replyDto.getReplyOrigin(); }
	 */
	
	@PostMapping("/write")
	public void write(@ModelAttribute ReplyDto replyDto, 
					HttpSession session) {
		long replyNo = replyDao.sequence();
		String loginId = (String)session.getAttribute("loginId");
		
		replyDto.setReplyNo(replyNo);
		replyDto.setReplyWriter(loginId);
		replyDao.insert(replyDto);
		
	}
//	@RequestMapping("/list")
	@PostMapping("/list")
	public List<ReplyDto> list(@RequestParam long replyOrigin){
		return replyDao.selectList(replyOrigin);
	}
	@PostMapping("/delete")
	public void delete(@RequestParam long replyNo) {
		replyDao.delete(replyNo);
	}
}

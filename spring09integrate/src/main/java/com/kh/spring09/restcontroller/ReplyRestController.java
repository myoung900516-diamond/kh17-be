package com.kh.spring09.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dao.ReplyDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.dto.ReplyDto;
import com.kh.spring09.vo.ReplyVO;

import jakarta.servlet.http.HttpSession;

//@CrossOrigin
@RestController
@RequestMapping("/rest/reply")
public class ReplyRestController {
	@Autowired
	private ReplyDao replyDao;
	@Autowired
	private BoardDao boardDao;

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
	//댓글목록
	
	@PostMapping("/list")
	public List<ReplyVO> list(@RequestParam long replyOrigin, HttpSession session){
		String loginId = (String)session.getAttribute("loginId");
		BoardDto boardDto = boardDao.selectOne(replyOrigin);
		
		List<ReplyDto> list = replyDao.selectList(replyOrigin);
		List<ReplyVO> newList = new ArrayList<>();
		for(ReplyDto replyDto : list) {
		boolean writer = boardDto.getBoardWriter() != null 
							&& boardDto.getBoardWriter().equals(replyDto.getReplyWriter());
		boolean owner = loginId != null && loginId.equals(replyDto.getReplyWriter());
			newList.add(ReplyVO.builder()
						.replyNo(replyDto.getReplyNo())
						.replyWriter(replyDto.getReplyWriter())
						.replyContent(replyDto.getReplyContent())
						.replyOrigin(replyDto.getReplyOrigin())
						.replyWtime(replyDto.getReplyWtime())
						.replyEtime(replyDto.getReplyEtime())
						.writer(writer)
						.owner(owner)
					.build());
		}
		
//		return replyDao.selectList(replyOrigin);
		return newList;
	}
	@PostMapping("/delete")
	public void delete(@RequestParam long replyNo) {
		replyDao.delete(replyNo);
	}
	
	@PostMapping("/edit")
	public void edit(@ModelAttribute ReplyDto replyDto) {
		replyDao.update(replyDto);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

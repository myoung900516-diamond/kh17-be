package com.kh.spring09.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.exception.GetOutException;
import com.kh.spring09.exception.TargetNotfoundException;
import com.kh.spring09.vo.PageVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/list")
	public String list(
//							@RequestParam(required = false) String column, 
//							@RequestParam(required = false) String keyword, 
//							Model model, 
//							@RequestParam(required = false, defaultValue= "1") int page, 
//							@RequestParam(required=false, defaultValue= "10")  int size 
							Model model, @ModelAttribute PageVO pageVO
			) {
		//공지사항 게시글
//		List<BoardDto> noticeList = boardDao.selectList("board_head", "공지");
		List<BoardDto> noticeList = boardDao.selectNoticeList();
//		model.addAttribute("noticeList", noticeList);
		
//		List<BoardDto> list = boardDao.selectList(column, keyword);
//		model.addAttribute("list", list);
		
//		List<BoardDto> boardlist = boardDao.selectList(column, keyword, page, size);
		List<BoardDto> boardlist = boardDao.selectList(pageVO);
		List<BoardDto> list = new ArrayList<>();
		list.addAll(noticeList);
		list.addAll(boardlist);
		model.addAttribute("list", list);
		model.addAttribute("noticeCount", noticeList.size());
		
		//페이징을 위해 추가로 전달할 값이 있다면 전달해야 한다
//		model.addAttribute("page", page);
//		model.addAttribute("size", size);
//		int beginBlock=(page-1) / 10 * 10 + 1;
//		int endBlock= beginBlock +9;
//		model.addAttribute("beginBlock", beginBlock);
//		int count = boardDao.count(column, keyword);
//		model.addAttribute("count", count);
//		int pageCount = (count - 1) / size +1;
//		model.addAttribute("endBlock", Math.min(pageCount, endBlock));
//		model.addAttribute("pageCount", pageCount);
//		
//		if(column != null && keyword != null) {
//		model.addAttribute("searchParams", 
//								"&column="+column+"&keyword="+keyword+"");
//		}
		int count = boardDao.count(pageVO);
		pageVO.setCount(count);
		model.addAttribute("pageVO", pageVO);
		return "board/list"; //뷰리졸버(View Resolver)
	}
	@RequestMapping("/detail")
	public String detail(@RequestParam long boardNo, Model model, 
					@ModelAttribute PageVO pageVO) {
//		String loginId = (String) session.getAttribute("loginId");
//		model.addAttribute("loginId", loginId);
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotfoundException();
		model.addAttribute("boardDto", boardDto);
		//이전글 다음글 
		model.addAttribute("prevBoardDto", boardDao.selectPreviousOne(boardNo));
		model.addAttribute("nextBoardDto", boardDao.selectNextOne(boardNo));
		model.addAttribute("pageVO", pageVO);
		return "board/detail";
	}
	
	
	@GetMapping("/edit")
	public String edit(@RequestParam long boardNo, Model model) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotfoundException("존재하지 않는 게시글");
		model.addAttribute("boardDto", boardDto);
		return "board/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto, HttpSession session) {
		if(boardDto.getBoardHead() != null && boardDto.getBoardHead().equals("공지")) {
			String loginLevel = (String)session.getAttribute("loginLevel");
			if(!loginLevel.equals("마스터")) {
				throw new GetOutException();
			}
		}		
		BoardDto findBoardDto = boardDao.selectOne(boardDto.getBoardNo());
		if(findBoardDto == null) throw new TargetNotfoundException("존재하지 않는 게시글");
		boardDao.update(boardDto);
		return "redirect:./detail?boardNo=" + boardDto.getBoardNo();
	}
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto, HttpSession session) {
//		int seq = boardDao.sequence();
		String loginId = (String)session.getAttribute("loginId");
		//작성한 글이 "공지"라면 "마스터 " 인지를 반드시 확인 
		if(boardDto.getBoardHead() != null && boardDto.getBoardHead().equals("공지")) {
			String loginLevel = (String)session.getAttribute("loginLevel");
			if(!loginLevel.equals("마스터")) {
				throw new GetOutException();
			}
		}
		
		long seq = boardDao.sequence();
		boardDto.setBoardNo(seq);
		boardDto.setBoardWriter(loginId);
		
		if(boardDto.getBoardParent()==null) {//새글이라면
			boardDto.setBoardGroup(seq);
		}
		else {//답글이라면
			BoardDto findBoardDto = boardDao.selectOne(boardDto.getBoardParent());
			boardDto.setBoardGroup(findBoardDto.getBoardGroup());
			boardDto.setBoardParent(findBoardDto.getBoardNo());
			boardDto.setBoardDepth(findBoardDto.getBoardDepth()+1);
		}
		
		
		
		boardDao.insert(boardDto);
//		return "redirect:./detail?boardNo=" + (boardDao.sequence()-1);
		return "redirect:./detail?boardNo=" + seq;
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam long boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotfoundException("존재하지 않는 게시글");
		boardDao.delete(boardNo);
		return "redirect:./list";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.kh.spring09.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dao.BoardLikeDao;
import com.kh.spring09.vo.LikeVo;

import jakarta.servlet.http.HttpSession;

//게시글과 관련된 비동기 통신을 처리하는 도구(board, board_like, board_read 등)

@RestController
@RequestMapping("/rest/board")
public class BoardRestController {
	@Autowired
	private BoardLikeDao boardLikeDao;
	@Autowired
	private BoardDao boardDao;
	
	//1.최초접속시 좋아요 여부와 현재 글의 좋아요 개수를 구해주는 매핑 /비회원 진입 가능
	@PostMapping("/like-check")
	public LikeVo likeCheck(@RequestParam long boardNo, HttpSession session){
		String loginId = (String)session.getAttribute("loginId");
		
		boolean action = boardLikeDao.check(loginId, boardNo);
		long count = boardLikeDao.count(boardNo);
		
//		return Map.of("action", action, "count", count);
		/*
		 * LikeVo likeVo = new LikeVo(); //Map<String, Object> map = new HashMap<>();
		 * likeVo.setAction(action); //map.put("action", action);
		 * likeVo.setCount(count);   //map.put("count", count);
		 * return likeVo;             //return map;
		 */
		
		return LikeVo.builder().action(action).count(count).build();//Builder패턴 //@Builder라는 어노테이션때문에 생김
	}
	
	//2.좋아요 클릭시 좋아요 토글 처리와 결과적으로 만들어진 좋아요 개수를 구해주는 매핑/비회원 진입 불가
	//-비회원 차단은 인터셉터에서 구현
	@PostMapping("/like-action")
	public LikeVo lickAction(@RequestParam long boardNo, HttpSession session){
		String loginId = (String)session.getAttribute("loginId");
		
		boolean current = boardLikeDao.check(loginId, boardNo);
		if(current) {//좋아요 설정한 적이 있으면 
			boardLikeDao.delete(loginId, boardNo);//좋아요 해제
		}
		else {
			boardLikeDao.insert(loginId, boardNo);//좋아요 설정	
		}
		
		long count = boardLikeDao.count(boardNo);
		//게시글 테이블 좋아요 개수를 최신화
		boardDao.updateBoardLikecount(boardNo);
//		return Map.of("action", !current , "count", count);
		return LikeVo.builder().action(!current).count(count).build();
	}
}

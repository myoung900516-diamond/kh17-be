package com.kh.spring09.controller;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dao.MemberExitDao;
import com.kh.spring09.dao.MemberHistoryDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.dto.MemberExitDto;
import com.kh.spring09.dto.MemberHistoryDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberExitDao memberExitDao;
	@Autowired
	private MemberHistoryDao memberHistoryDao;
	
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "redirect:./joinFinish";
	}
	@RequestMapping("/joinFinish")
	public String joinFinish() {
		return "/WEB-INF/views/member/joinFinish.jsp";
	}
//	@GetMapping("/login")
//	public String login(@RequestParam(required = false) String memberId, 
//						@RequestParam(required = false) String memberPassword, 
//						Model model) {
//		MemberDto memberDto = memberDao.selectOne(memberId);
//		if(memberDto == null) throw new TargetNotfoundException("회원정보를 잘못 입력하였습니다");
//		model.addAttribute("memberDto", memberDto);
//		return "/WEB-INF/views/member/login.jsp";
//	}
//	@PostMapping("/login")
//	public String login(@ModelAttribute MemberDto memberDto) {
//		memberDao.update(memberDto);
//		return "redirect:/";
//	}
	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/member/login.jsp";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, 
//							 @RequestHeader("User-Agent") String userAgent, //아이피 주소를 불러 올 수 없어서 못씀 
							 HttpServletRequest request,
								HttpSession session) {
//		MemberDto findMemberDto = memberDao.selectOne(memberDto.getMemberId());
		MemberExitDto findMemberDto = memberExitDao.selectOne(memberDto.getMemberId());
		if(findMemberDto == null) {
				return "redirect:./login?error"; //redirect는 GET만 가능
		}
//		if(!memberDto.getMemberId().equals(memberId) || 
//			!memberDto.getMemberPassword().equals(memberPassword))
//		throw new TargetNotfoundException("회원정보를 잘못 입력하였습니다");
//		if(memberDto.getMemberId().equals(memberId) && 
//				memberDto.getMemberPassword().equals(memberPassword))
		
		boolean isPasswordValid = memberDto.getMemberPassword()
												.equals(findMemberDto.getMemberPassword());
		if(!isPasswordValid) {
			return "redirect:./login?error";
		}
		//회원 차단이 y라면
		if(findMemberDto.getMemberBlock().equals("Y")) {
			return "redirect:./block";//차단페이지로 이동
		}
		
		//탈퇴 예정인 회원이라면? (탈퇴 버튼 누른 사람)
		if(findMemberDto.isWaitForDelete()) return "redirect:./waiting";
		
		//-로그인시간 갱신
		memberDao.updateMemberLogin(findMemberDto.getMemberId());
		//로그인 이력 생성
		MemberHistoryDto memberHistoryDto = new MemberHistoryDto();
		//정보 입력
		memberHistoryDto.setMemberHistoryOrigin(findMemberDto.getMemberId());
		memberHistoryDto.setMemberHistoryAddress(request.getRemoteAddr());
		memberHistoryDto.setMemberHistoryAgent(request.getHeader("User-Agent"));
		memberHistoryDao.insert(memberHistoryDto);
		
		//-세션에 로그인 되었음을 표시 
		session.setAttribute("loginId", findMemberDto.getMemberId());
		session.setAttribute("loginLevel", findMemberDto.getMemberLevel());
		
		//비밀번호변경한 시간을 비교해서 일정기간 이상이면 비밀번호 변경 안내 페이지로 리다이렉트
		Timestamp last = findMemberDto.getMemberChange();
		if(last == null) {
			last = findMemberDto.getMemberJoin();
		}
		LocalDateTime lastChange = findMemberDto.getMemberChange().toLocalDateTime();
		LocalDateTime current = LocalDateTime.now();
		Duration duration = Duration.between(lastChange, current);
		if(duration.toHours() >= 1) {
			return "redirect:./notice";
		}
		
		return "redirect:/";
	}
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		session.removeAttribute("loginLevel");
		return "redirect:/";
	}
	@RequestMapping("/block")
	public String block() {
		return "/WEB-INF/views/member/block.jsp";
	}
	
	@RequestMapping("/waiting")
	public String waiting() {
		return "/WEB-INF/views/member/waiting.jsp";
	}
	
	//마이페이지
	//세션에 들어있는 아이디를 이용해서 현재 회원의 모든 정보를 화면에 전달 
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		//session에 존재하는 현재 사용자 영역에 저장된 loginId라는 이름의 값을 불러오세요! 
		String loginId = (String) session.getAttribute("loginId"); //다운캐스팅
		MemberDto memberDto = memberDao.selectOne(loginId);
		model.addAttribute("memberDto", memberDto);
		
		List<MemberHistoryDto> loginHistory = 
								memberHistoryDao.selectList(loginId, 1, 10);
		model.addAttribute("loginHistory", loginHistory);
		
		return "/WEB-INF/views/member/mypage.jsp";
	}
	
	@GetMapping("/password")
	public String password() {
		return "/WEB-INF/views/member/password.jsp";
	}
	@PostMapping("/password")
	public String password(@RequestParam String originPw, @RequestParam String changePw, 
									HttpSession session) {
		if(originPw.equals(changePw)) return "redirect:./password?error";
		
		String loginId = (String) session.getAttribute("loginId");
		MemberDto memberDto = memberDao.selectOne(loginId);
		
		if(!memberDto.getMemberPassword().equals(originPw)) {
			return "redirect:./password?error";
		}
		
//        memberDto.getMemberPassword();
//        model.addAttribute("memberDto",memberDto);
//
//			boolean isPasswordValid = memberDto.getMemberPassword()
//														.equals(memberDto.getMemberPassword());
//			if(!isPasswordValid) {
//			return "redirect:./password";
//			}
			memberDto.setMemberPassword(changePw);
			memberDao.updateMemberPassword(memberDto);
			return "redirect:./passwordFinish";	
	}
	@RequestMapping("/passwordFinish")
	public String passwordFinish() {
		return "/WEB-INF/views/member/passwordFinish.jsp";
	}
	@GetMapping("/edit")
	public String edit(Model model, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		MemberDto memberDto = memberDao.selectOne(loginId);
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(HttpSession session, @ModelAttribute MemberDto memberDto) {
		String loginId = (String) session.getAttribute("loginId");
		
		MemberDto findMemberDto = memberDao.selectOne(loginId);
		boolean valid = findMemberDto.getMemberPassword().equals(memberDto.getMemberPassword());
		if(!valid) return "redirect:./edit?error";
		
		memberDto.setMemberId(loginId);
		memberDao.update(memberDto);
		
		return "redirect:./mypage";
	}
	@GetMapping("/goodbye")
	public String goodbye() {
//			HttpSession session, Model model) {
//		String loginId = (String)session.getAttribute("loginId");
//		MemberDto memberDto = memberDao.selectOne(loginId);
//		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/goodbye.jsp";
	}
	@PostMapping("/goodbye")
	public String goodbye(HttpSession session, @RequestParam String memberPassword) {
		String loginId = (String) session.getAttribute("loginId");
		
		MemberDto memberDto = memberDao.selectOne(loginId);
		boolean valid = memberDto.getMemberPassword().equals(memberPassword);
		if(!valid) return "redirect:./goodbye?error";
		
//		memberDto.setMemberId(loginId);
		//반드시 같이 실행되어야함
		//아주 강함 결합도를 가지고 있음
//		memberDao.delete(loginId);//
		memberExitDao.insert(loginId);
		session.removeAttribute("loginId");
		session.removeAttribute("loginLevel");
		
		return "redirect:./goodbyeFinish";
	}
	
	@RequestMapping("/goodbyeFinish")
	public String goodbyeFinish() {
		return "/WEB-INF/views/member/goodbyeFinish.jsp";
	}
	
	@RequestMapping("/history")
	public String history(HttpSession session, 
								@RequestParam(required = false) String beginDate, 
								@RequestParam(required = false) String endDate, 
								@RequestParam(required = false, defaultValue = "1") int page, 
								@RequestParam(required = false, defaultValue = "20") int size, 
								Model model) {
		String loginId = (String) session.getAttribute("loginId");
		
		int endRow = page * size;
		int beginRow = endRow - (size-1);
		
//		MemberHistoryDto memberHistoryDto = new MemberHistoryDto();
//		memberHistoryDto.setMemberHistoryOrigin(loginId); 
		List<MemberHistoryDto> loginhistory = 
					memberHistoryDao.selectList(loginId, beginDate, endDate, beginRow, endRow);
		model.addAttribute("loginhistory", loginhistory);
		return "/WEB-INF/views/member/history.jsp";
	}
	
	@RequestMapping("/notice")
	public String notice() {
		return "/WEB-INF/views/member/notice";
	}
	
	@RequestMapping("/later")
	public String later(HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		MemberDto memberDto = memberDao.selectOne(loginId);
		memberDao.updateMemberPassword(memberDto);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

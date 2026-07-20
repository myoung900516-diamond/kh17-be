package com.kh.spring11.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.CommonsApiResponse;
import com.kh.spring11.service.AuthService;
import com.kh.spring11.vo.auth.AuthLoginRequestVO;
import com.kh.spring11.vo.auth.AuthLoginResponseVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name="인증 처리 서비스", description="stateless 서버의 인증 처리 로직 구현")
@CommonsApiResponse

@CrossOrigin(
		origins = "http://localhost:5173",
		allowCredentials = "true"
)
@RestController
@RequestMapping("/service/auth")
public class AuthRestController {
	
	@Autowired
	private AuthService authService;
	
	@ApiResponse(responseCode="200", description="로그인성공")
	@ApiResponse(responseCode="404", description="로그인 정보 불일치")
	@PostMapping(value="/login", produces="application/json")
//	public AuthLoginResponseVO login(@RequestBody AuthLoginRequestVO request) {
	public ResponseEntity<AuthLoginResponseVO> login(@RequestBody AuthLoginRequestVO request) {
		//로그인 처리를 수행하고 결과를 얻어낸다
		AuthLoginResponseVO response = authService.login(request);
		
		//쿠키생성
		ResponseCookie postIt = ResponseCookie
					.from("loginId", response.getAccountId())
					//각종설정들(만료시간,
					.maxAge(Duration.ofMinutes(30L))//유효시간30분
					.path("/")//적용범위
					.httpOnly(false)//true면 서버전용, false 면 클라이언트겸용
					.secure(false)//https 사용 여부
					.sameSite("Lax")//허용범위(NONE:자유, Lax:유연, Strict:엄격)
					.build();
		
		//결과 반환
		return ResponseEntity.ok()
				//쿠키를 추가하는 설정
					.header(HttpHeaders.SET_COOKIE, postIt.toString())
					.body(response);
	}
	
	//로그아웃 매핑
	//-서버에서 사용자의 로그아웃에 대한 핵심작업은 "쿠키삭제"이다
	//-하지만, 쿠키는 지우는 명령이 없다(제한시간을 설정해서 만드는 것밖에 없음)
	//-삭제효과를 내기 위해 0초 뒤에 만료되는 쿠키를 생성해서 덮어쓰기 처리
	@DeleteMapping("/logout")
	public ResponseEntity<Void> logout(
			@CookieValue(name="loginId", required=false) String accountId
			) {
//		if() {
//			
//		}
		
		//삭제를 위한 쿠키 생성(생성시와 똑같지만 만료시간이 0초여야함)
		ResponseCookie postIt = ResponseCookie
					.from("loginId", accountId)
					//각종설정들(만료시간,
					.maxAge(Duration.ZERO)//유효시간30분
					.path("/")//적용범위
					.httpOnly(false)//true면 서버전용, false 면 클라이언트겸용
					.secure(false)//https 사용 여부
					.sameSite("Lax")//허용범위(NONE:자유, Lax:유연, Strict:엄격)
					.build();

		return ResponseEntity.noContent()
				.header(HttpHeaders.SET_COOKIE, postIt.toString())
				.build();
		
	}
	
	

}

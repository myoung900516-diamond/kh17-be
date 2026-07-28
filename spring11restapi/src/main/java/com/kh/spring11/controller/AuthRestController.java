package com.kh.spring11.controller;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.CommonsApiResponse;
import com.kh.spring11.configuration.JwtProperties;
import com.kh.spring11.dao.AccountDao;
import com.kh.spring11.dao.AccountRefreshDao;
import com.kh.spring11.dto.AccountDto;
import com.kh.spring11.dto.AccountRefreshDto;
import com.kh.spring11.error.GetOutException;
import com.kh.spring11.error.WhoAreYouException;
import com.kh.spring11.service.AuthService;
import com.kh.spring11.service.JwtService;
import com.kh.spring11.vo.auth.AuthLoginRequestVO;
import com.kh.spring11.vo.auth.AuthLoginResponseVO;
import com.kh.spring11.vo.jwt.TokenCreateRequestVO;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
@Tag(name="인증 처리 서비스", description="stateless 서버의 인증 처리 로직 구현")
@CommonsApiResponse


@Slf4j
//@CrossOrigin(
//		origins = "http://localhost:5173",
//		allowCredentials = "true"
//)
@RestController
@RequestMapping("/service/auth")
public class AuthRestController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private JwtProperties jwtProperties;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private AccountRefreshDao accountRefreshDao;
	
	@ApiResponse(responseCode="200", description="로그인성공")
	@ApiResponse(responseCode="404", description="로그인 정보 불일치")
	@PostMapping(value="/login", produces="application/json")
//	public AuthLoginResponseVO login(@RequestBody AuthLoginRequestVO request) {
	public ResponseEntity<AuthLoginResponseVO> login(
			@RequestHeader(
					value = "User-Agent",
					required = false,
					defaultValue = "UNKNOWN"
			) String userAgent,
			HttpServletRequest req,
			@RequestBody AuthLoginRequestVO request
			) {
		//로그인 처리를 수행하고 결과를 얻어낸다
		AuthLoginResponseVO response = authService.login(request);
		
		
		//차단된 회원이면 403처리
		AccountDto accountDto = accountDao.selectOne(request.getAccountId());
//		System.out.println(accountDto);
//		if(accountDto.getAccountBlock().equals("Y")) {
//			
//			throw new GetOutException();
//		}
		
		//비밀번호를 생성한지 30일이 지났으면 needUpdate를 true로 변환
//		Timestamp changed = accountDto.getAccountChange();
//		if(changed != null) {
//			LocalDateTime at = changed.toLocalDateTime();
//			LocalDateTime now = LocalDateTime.now();
//			if( at.plusDays(30).isBefore(now)) {
//				response.setNeedUpdate(true);
//			}
//		}
		
		//쿠키생성
//		ResponseCookie postIt = ResponseCookie
//					.from("loginId", response.getAccountId())
//					//각종설정들(만료시간,
//					.maxAge(Duration.ofMinutes(30L))//유효시간30분
//					.path("/")//적용범위
//					.httpOnly(false)//true면 서버전용, false 면 클라이언트겸용
//					.secure(false)//https 사용 여부
//					.sameSite("Lax")//허용범위(NONE:자유, Lax:유연, Strict:엄격)
//					.build();
		
		//토큰 생성
		TokenCreateRequestVO tokenRequest = new TokenCreateRequestVO();
		BeanUtils.copyProperties(response, tokenRequest);
		
		String accessToken = jwtService.createAccessToken(tokenRequest);
		String refreshToken = jwtService.createRefreshToken(tokenRequest.getAccountId());
		
		//쿠키생성
		ResponseCookie accessCookie = ResponseCookie
				.from("accessToken", accessToken)
				//각종설정들(만료시간,
				.maxAge(Duration.ofSeconds(
						jwtProperties.getAccessTokenValidity()
				))//유효시간30분
				.path("/")//적용범위
				.httpOnly(true)//
				.secure(false)//https 사용 여부
				.sameSite("Lax")//허용범위(NONE:자유, Lax:유연, Strict:엄격)
				.build();
		ResponseCookie refreshCookie = ResponseCookie
				.from("refreshToken", refreshToken)
				//각종설정들(만료시간,
				.maxAge(Duration.ofSeconds(
						jwtProperties.getRefreshTokenValidity()
				))//유효시간4주
				.path("/service/auth/")//적용범위
				.httpOnly(true)//
				.secure(false)//https 사용 여부
				.sameSite("Lax")//허용범위(NONE:자유, Lax:유연, Strict:엄격)
				.build();
		
		//refresh token 정보를 DB에 저장
		accountRefreshDao.insertOrUpdate(
				AccountRefreshDto.builder()
					.accountId(response.getAccountId())
					.userAgent(userAgent)
					.userAddress(req.getRemoteAddr())
					.tokenValue(refreshToken)
				.build()
		);
		
		//최종로그인시각 갱신
		accountDao.updateAccountLogin(response.getAccountId());
		
		
		
		//결과 반환
		return ResponseEntity.ok()
				//쿠키를 추가하는 설정
					.header(
							HttpHeaders.SET_COOKIE, 
							accessCookie.toString(),
							refreshCookie.toString()
							)
					.body(response);
	}
	
	//로그아웃 매핑
	//-서버에서 사용자의 로그아웃에 대한 핵심작업은 "쿠키삭제"이다
	//-하지만, 쿠키는 지우는 명령이 없다(제한시간을 설정해서 만드는 것밖에 없음)
	//-삭제효과를 내기 위해 0초 뒤에 만료되는 쿠키를 생성해서 덮어쓰기 처리
	@DeleteMapping("/logout")
	public ResponseEntity<Void> logout(
			@RequestHeader(
					value="User-Agent",
					required = false,
					defaultValue ="UNKNOWN"
			) String userAgent,
			HttpServletRequest req,
			@CookieValue(value = "accessToken", required=false) String accessToken,
			@CookieValue(value = "refreshToken", required=false) String refreshToken
			
			) {
		
		//삭제를 위한 쿠키 생성(생성시와 똑같지만 만료시간이 0초여야함)
//		ResponseCookie postIt = ResponseCookie
//					.from("loginId", accountId)
//					//각종설정들(만료시간,
//					.maxAge(Duration.ZERO)//유효시간30분
//					.path("/")//적용범위
//					.httpOnly(false)//true면 위조 불가, false 면 수정가능
//					.secure(false)//https 사용 여부
//					.sameSite("Lax")//허용범위(NONE:자유, Lax:유연, Strict:엄격)
//					.build();
		
		//삭제를 위한 쿠키 생성(생성시와 똑같지만 만료시간이 0초여야함)
		ResponseCookie accessCookie = ResponseCookie
					.from("accessToken", "")
					//각종설정들(만료시간,
					.maxAge(Duration.ZERO)//유효시간30분
					.path("/")//적용범위
					.httpOnly(true)//true면 서버전용, false 면 클라이언트겸용
					.secure(false)//https 사용 여부
					.sameSite("Lax")//허용범위(NONE:자유, Lax:유연, Strict:엄격)
					.build();
		ResponseCookie refreshCookie = ResponseCookie
				.from("refreshToken", "")
				//각종설정들(만료시간,
				.maxAge(Duration.ZERO)//유효시간30분
				.path("/service/auth/")//적용범위
				.httpOnly(true)//true면 서버전용, false 면 클라이언트겸용
				.secure(false)//https 사용 여부
				.sameSite("Lax")//허용범위(NONE:자유, Lax:유연, Strict:엄격)
				.build();
		
		//DB에 저장된 refresh token 정보를 삭제
		//accessToken 검사 → refreshToken → 패스
		try {
			if(accessToken != null) {
				TokenParseResponseVO parseVO =
						jwtService.parseAccessToken(accessToken);
				accountRefreshDao.delete(
						AccountRefreshDto.builder()
							.accountId(parseVO.getAccountId())
							.userAgent(userAgent)
							.userAddress(req.getRemoteAddr())
						.build()
				);
			}
			else if(refreshToken != null) {
				String accountId = jwtService.parseRefreshToken(refreshToken);
				accountRefreshDao.delete(
						AccountRefreshDto.builder()
							.accountId(accountId)
							.userAgent(userAgent)
							.userAddress(req.getRemoteAddr())
						.build()
				);
			}
		}
		catch(Exception e) {
			
			//응답 생성
		return ResponseEntity.noContent()
				.header(
					HttpHeaders.SET_COOKIE,
					accessCookie.toString(),
					refreshCookie.toString()
				)
				.build();
		}

		
		return ResponseEntity.noContent()
				.header(HttpHeaders.SET_COOKIE, accessCookie.toString(), refreshCookie.toString())
				.build();
		
	}
	
	//로그인 갱신(refresh) 매핑
	//- 사용자의 액세스토큰이 만료되었을 때 이를 재발급해주는 매핑 
	//- refreshToken 쿠키를 읽어서 유효성 검증 및 DB 발급내역 조사까지 해서 유효성 판정 
	//- 통과하면 login과 동일한 작업을 수행, 통과 못하면 401(Unauthorized) 발송
	
	@PostMapping("/refresh")
	public ResponseEntity<AuthLoginResponseVO> refresh(
				@RequestHeader(
					value="User-Agent",
					required=false,
					defaultValue = "UNKNOWN") String userAgent,
				HttpServletRequest req,
				@CookieValue(name = "refreshToken", required = false) String refreshToken
			){
		//만약 쿠키가 없으면 로그인 상태가 아닌것이다
		if(refreshToken == null) throw new WhoAreYouException();
		
		//토큰 해석 및 DB검증 (현재 DB생략되어있음)
		//-토큰이 문제가 되면 JwtValidationException이 발생하며 자동으로 401발송
		String accountId = jwtService.parseRefreshToken(refreshToken);
		
		//(+추가)실제 DB에 존재하는 토큰과 사용자가 가지고온 토큰의 일치여부를 검사
		//→만약 안맞으면 WhoAreYouException발생
		AccountRefreshDto accountRefreshDto =
				accountRefreshDao.find(
					AccountRefreshDto.builder()
						.accountId(accountId)
						.userAgent(userAgent)
						.userAddress(req.getRemoteAddr())
					.build()
				);
		log.debug("accountRefreshDto = {}", accountRefreshDto);
		if(accountRefreshDto == null)//발급한적이 없는데?
			throw new WhoAreYouException();//너 누구야(401)
		log.debug("token1 = {}", refreshToken);
		log.debug("token2 = {}", accountRefreshDto.getTokenValue());
		log.debug("equals = {}", accountRefreshDto.getTokenValue().equals(refreshToken));
		
		if(accountRefreshDto.getTokenValue().equals(refreshToken) == false)//토큰이 달라?
			throw new WhoAreYouException();//너 누구야?(401)
		
		
		
		
		
		//아이디의 실 정보를 조회
		AccountDto accountDto = accountDao.selectOne(accountId);
		
		//토큰 및 cookie생성
		TokenCreateRequestVO createVO = new TokenCreateRequestVO();
		BeanUtils.copyProperties(accountDto, createVO);
		
		String accessToken = jwtService.createAccessToken(createVO);
		String newRefreshToken = jwtService.createRefreshToken(accountId);
		
		ResponseCookie accessCookie = ResponseCookie
				.from("accessToken", accessToken)
				//각종설정들(만료시간,
				.maxAge(Duration.ofSeconds(
						jwtProperties.getAccessTokenValidity()
				))//유효시간30분
				.path("/")//적용범위
				.httpOnly(true)//
				.secure(false)//https 사용 여부
				.sameSite("Lax")//허용범위(NONE:자유, Lax:유연, Strict:엄격)
				.build();
		
		
		ResponseCookie refreshCookie = ResponseCookie
				.from("refreshToken", newRefreshToken)
				//각종설정들(만료시간,
				.maxAge(Duration.ofSeconds(
						jwtProperties.getRefreshTokenValidity()))//유효시간4주
				.path("/service/auth/")//적용범위
				.httpOnly(true)//
				.secure(false)//https 사용 여부
				.sameSite("Lax")//허용범위(NONE:자유, Lax:유연, Strict:엄격)
				.build();
		
		//refresh token 정보를 DB에 저장
		accountRefreshDao.insertOrUpdate(
				AccountRefreshDto.builder()
					.accountId(accountId)
					.userAgent(userAgent)
					.userAddress(req.getRemoteAddr())
					.tokenValue(newRefreshToken)
				.build()
		);
		//결과 반환
		AuthLoginResponseVO response = new AuthLoginResponseVO();
		BeanUtils.copyProperties(accountDto, response);
		return ResponseEntity.ok()
				//쿠키를 추가하는 설정
					.header(
							HttpHeaders.SET_COOKIE, 
							accessCookie.toString(),
							refreshCookie.toString()
							)
					.body(response);
		
	}
	
	
	

}

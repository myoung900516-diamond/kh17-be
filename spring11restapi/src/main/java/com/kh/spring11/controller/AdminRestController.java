package com.kh.spring11.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.AuthApiResponse;
import com.kh.spring11.dao.AccountDao;
import com.kh.spring11.dto.AccountDto;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.service.EmailService;
import com.kh.spring11.service.RandomService;
import com.kh.spring11.vo.account.AccountBlockResponseVO;
import com.kh.spring11.vo.account.AccountFindResponseVO;
import com.kh.spring11.vo.account.AccountSearchResultVO;
import com.kh.spring11.vo.admin.AdminComplexSearchRequestVO;
import com.kh.spring11.vo.admin.AdminComplexSearchResponseVO;
import com.kh.spring11.vo.cert.CertTempPasswordResponseVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;

@Tag(name = "관리자API")
//@CommonsApiResponse
@AuthApiResponse

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RandomService randomService;
	
//	@PostMapping("/complexSearch")
//	public AdminComplexSearchResponseVO complexSearch(@RequestBody AdminComplexSearchRequestVO request) {
//		
//		int count = accountDao.complexSearchCount(request);
//		boolean last = request.getSize() == null? true : count <= request.getSize();
//		
//		
//		return AdminComplexSearchResponseVO.builder()
//					.list(accountDao.complexSearch(request))
//					.last(last)
//				.build();
//		
//	}
	
	// 회원 정보를 반환하는 매핑(주의: 내정보 아님)
		@ApiResponse(responseCode = "200", description = "조회 성공")
		@GetMapping(value = "/{accountId}", produces = "application/json")
		public AccountFindResponseVO find(@PathVariable String accountId) {
			AccountDto accountDto = accountDao.selectOne(accountId);
			if (accountDto == null)
				throw new TargetNotfoundException();
			
//			로딩중인 화면을 보려고 일부러 느리게 만듬 
//			try {
//				Thread.sleep(Duration.ofSeconds(2L));
//			} catch (InterruptedException e) {}

			AccountFindResponseVO response = new AccountFindResponseVO();
			BeanUtils.copyProperties(accountDto, response);// 가능한 항목 복사

			return response;
		}
		@ApiResponse(responseCode = "200", description = "관리자용 회원 검색")
		@PostMapping(value="/search", produces="application/json")
		public AdminComplexSearchResponseVO search(@RequestBody AdminComplexSearchRequestVO request) {
			
			int count = accountDao.complexSearchCount(request);
			boolean last = request.getSize() == null? true : count <= request.getSize();
			List<AccountSearchResultVO> list = accountDao.complexSearch(request);
			
			return AdminComplexSearchResponseVO.builder()
						.list(list)
						.last(last)
					.build();
			
		}
		
		@ApiResponse(responseCode = "200", description="차단/해제 성공")
		@PatchMapping(value="/block/{accountId}", produces="application/json")
		public AccountBlockResponseVO block(
				
				@PathVariable String accountId
				) {
			
			//없는 경우 처리
			AccountDto findaccountDto = accountDao.selectOne(accountId);
			if(findaccountDto == null) throw new TargetNotfoundException();
			
			AccountBlockResponseVO response = new AccountBlockResponseVO();
			
			accountDao.blockRequest(accountId);
			
			AccountDto accountDto = accountDao.selectOne(accountId);
			
			
			BeanUtils.copyProperties(accountDto, response);
			
//			System.out.println("accountDto" + response);
			return response;
			
		}
		
		@ApiResponse(responseCode="200", description="임시비밀번호 발송성공")
		@PostMapping("/tempPassword/{accountId}")
		public CertTempPasswordResponseVO tempPassword(@PathVariable String accountId) throws MessagingException, IOException {
			AccountDto accountDto = accountDao.selectOne(accountId);
			if(accountDto == null) throw new TargetNotfoundException();
			
			//임시 비밀번호 생성(숫자12자리)
			String tempPassword = randomService.generateString(12);
			
			//db변경
//			accountDao.updateAccountPassword(accountId, randomPassword);
//			accountDto
			
			
//			String encrypt = passwordEncoder.encode(tempPassword);
			accountDto.setAccountPassword(tempPassword);
			accountDao.updateAccountPassword(accountDto);
			
			emailService.sendTempPassword(accountDto.getAccountEmail(), tempPassword);
			
			
			return CertTempPasswordResponseVO.builder()
						.result(true)
					.build();
			
		}
		

}

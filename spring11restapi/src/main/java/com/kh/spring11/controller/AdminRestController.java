package com.kh.spring11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.dao.AccountDao;

@RestController("/api/admin")
public class AdminRestController {
	
	@Autowired
	private AccountDao accountDao;
	
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

}

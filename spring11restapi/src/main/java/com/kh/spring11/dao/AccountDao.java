package com.kh.spring11.dao;

import java.util.List;

import com.kh.spring11.dto.AccountDto;
import com.kh.spring11.vo.account.AccountSearchResultVO;
import com.kh.spring11.vo.admin.AdminComplexSearchRequestVO;

public interface AccountDao {
	
	void insert(AccountDto accountDto);
	
	AccountDto selectOne(String accountId);
	
	boolean checkAvailableId(String accountId);
	boolean checkAvailableNickname(String accountNickname);
	boolean checkAvailableEmail(String accountEmail);
	
	boolean updateAccountLogin(String accountId);
	boolean updateAccountPassword(AccountDto accountDto);

	boolean updateAll(AccountDto accountDto);
	
	
	List<AccountSearchResultVO> complexSearch(AdminComplexSearchRequestVO request);
	int complexSearchCount(AdminComplexSearchRequestVO request);
	
	boolean blockRequest(String accountId);

	boolean updateAccountChange(String accountId);
	
	

}

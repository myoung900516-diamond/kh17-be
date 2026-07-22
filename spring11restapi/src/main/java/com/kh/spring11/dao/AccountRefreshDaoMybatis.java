package com.kh.spring11.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.AccountRefreshDto;

@Repository
public class AccountRefreshDaoMybatis implements AccountRefreshDao {
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public void insertOrUpdate(AccountRefreshDto accountRefreshDto) {
		AccountRefreshDto findDto = sqlSession.selectOne("mapper.accountRefresh.find", accountRefreshDto);
		if(findDto == null) {
			//insert
			sqlSession.insert("mapper.accountRefresh.add", accountRefreshDto);
		}
		else {
			//update
			sqlSession.update("mapper.accountRefresh.change", accountRefreshDto);
		}
	}

	@Override
	public void delete(String accountId) {
		sqlSession.delete("mapper.accountRefresh.delete", accountId);

	}

	@Override
	public AccountRefreshDto find(String accountId) {
		return sqlSession.selectOne("mapper.accountRefresh.find", accountId);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


package com.kh.spring09.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.mapper.MemberMapper;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MemberMapper memberMapper;
	
	
	
	

}

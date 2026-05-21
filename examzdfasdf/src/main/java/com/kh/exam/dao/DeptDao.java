package com.kh.exam.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.exam.dto.DeptDto;
import com.kh.exam.mapper.DeptMapper;

@Repository
public class DeptDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DeptMapper deptMapper;
	
	
	//등록
	
	public void insert(DeptDto deptDto) {
		String sql = "insert into dept("
					+ "dept_id, dept_name, dept_use_yn"
					+ ") values(?, ?, ?)";
		Object[] params = {deptDto.getDeptId()
							, deptDto.getDeptName(), deptDto.getDeptUseYN()};
		jdbcTemplate.update(sql, params);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

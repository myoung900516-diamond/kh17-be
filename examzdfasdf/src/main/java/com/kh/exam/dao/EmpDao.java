package com.kh.exam.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.exam.dto.EmpDto;
import com.kh.exam.mapper.EmpMapper;

@Repository
public class EmpDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EmpMapper empMapper;
	
	public int sequence() {
		String sql = "select emp_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	public void insert(EmpDto empDto) {
		String sql = "insert into emp("
					+ "emp_id, emp_name, emp_email, emp_phone"
					+ ", emp_position, emp_hire_date, emp_use_yn "
					+ ") values(?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				empDto.getEmpId(), empDto.getEmpName(), empDto.getEmpEmail(), 
				empDto.getEmpPhone(), empDto.getEmpPosition(), 
				empDto.getEmpHireDate(), empDto.getEmpUseYN()
		};
		jdbcTemplate.update(sql, params);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

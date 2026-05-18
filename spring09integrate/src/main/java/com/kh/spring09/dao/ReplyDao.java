package com.kh.spring09.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.ReplyDto;
import com.kh.spring09.mapper.ReplyMapper;

@Repository
public class ReplyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	public long sequence() {
		String sql = "select reply_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, long.class);
	}
	public void insert(ReplyDto replyDto) {
		String sql = "insert into reply(reply_no, reply_writer, "
					+ "reply_origin, reply_content) "
					+ "values(?, ?, ?, ?)";
		Object[] params = {replyDto.getReplyNo(), replyDto.getReplyWriter(), 
							replyDto.getReplyOrigin(), replyDto.getReplyContent()};
		jdbcTemplate.update(sql, params);
	}

}

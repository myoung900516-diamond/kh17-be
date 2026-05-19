package com.kh.spring09.dao;

import java.util.List;

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
	
	public List<ReplyDto> selectList(long replyOrigin){
		String sql = "select * from reply "
					+ "where reply_origin=? "
					+ "order by reply_no asc";
		Object[] params = {replyOrigin};
		return jdbcTemplate.query(sql, replyMapper, params);
	}
	
	public boolean delete(long replyNo) {
		String sql = "delete reply where reply_no = ?";
		Object[] params = {replyNo};
		return jdbcTemplate.update(sql, params)>0;
	}
	public boolean update(ReplyDto replyDto) {
		String sql = "update reply set reply_content = ?, "
				+ " reply_etime=systimestamp "
				+ "where reply_no=?";
		Object[] params = {replyDto.getReplyContent(), replyDto.getReplyNo()};
		return jdbcTemplate.update(sql, params)>0 ;
	}
	
	public ReplyDto selectOne(long replyNo) {
		String sql = "select * from reply where reply_no = ? ";
		Object[] params = {replyNo};
		List<ReplyDto> list = jdbcTemplate.query(sql, replyMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package com.kh.spring09.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.mapper.MemberMapper;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MemberMapper memberMapper;
	
	public void insert(MemberDto memberDto) {
		String sql = "insert into member("
				+ "member_id, member_email, member_password, member_nickname, "
				+ "member_birth, member_contact, member_post, member_address1, "
				+ "member_address2, member_level, member_message, "
				+ "member_join, member_login, member_change, member_block, "
				+ "member_point) "
				+ "values("
				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				memberDto.getMemberId(), memberDto.getMemberEmail(), 
				memberDto.getMemberPassword(), memberDto.getMemberNickname(), 
				memberDto.getMemberBirth(), memberDto.getMemberContact(), 
				memberDto.getMemberPost(), memberDto.getMemberAddress1(), 
				memberDto.getMemberAddress2(), memberDto.getMemberLevel(), 
				memberDto.getMemberMessage(), memberDto.getMemberJoin(), 
				memberDto.getMemberLogin(), memberDto.getMemberChange(), 
				memberDto.getMemberBlock(), memberDto.getMemberPoint() 
				};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(MemberDto memberDto) {
		String sql = "update member "
				+ "set member_email=?, member_password=?, member_nickname=?, "
				+ "member_birth=?, member_contact=?, member_post=?, member_address1=?, "
				+ "member_address2=?, member_level=?, member_message=?, "
				+ "member_join=?, member_login=?, member_change=?, member_block=?, "
				+ "member_point=? "
				+ "where member_id = ? ";
		Object[] params = {
				memberDto.getMemberEmail(), 
				memberDto.getMemberPassword(), memberDto.getMemberNickname(), 
				memberDto.getMemberBirth(), memberDto.getMemberContact(), 
				memberDto.getMemberPost(), memberDto.getMemberAddress1(), 
				memberDto.getMemberAddress2(), memberDto.getMemberLevel(), 
				memberDto.getMemberMessage(), memberDto.getMemberJoin(), 
				memberDto.getMemberLogin(), memberDto.getMemberChange(), 
				memberDto.getMemberBlock(), memberDto.getMemberPoint(), 
				memberDto.getMemberId(),};
		return jdbcTemplate.update(sql, params) > 0 ;
	}
	public boolean delete(String memberId) {
		String sql = "delete member where member_id=?";
		Object[] params = {memberId};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	public List<MemberDto> selectList(){
		String sql = "select * from member order by member_id asc";
		MemberMapper memberMapper = new MemberMapper();
		return jdbcTemplate.query(sql, memberMapper);
	}
	
	public List<MemberDto> selectList(String column, String keyword){ 
		if(column == null || keyword == null) return selectList();
		if(column.isEmpty()||keyword.isEmpty()) return selectList();
		
		Set<String> allowlist = Set.of(
				"member_id", "member_email", "member_password", "member_nickname", 
				"member_birth", "member_contact", "member_post", "member_address1", 
				"member_address2", "member_level", "member_block");
		//질문: 가입날짜별로 조회는? 200포인트대 회원 조회는? 왜 문자열로만 조회하나? 
		if(allowlist.contains(column)==false) return List.of();
		String sql = "select * from member "
				+ "where instr( "+column+", ?) >0 order by member_id asc";
		Object[] params = {keyword};
		MemberMapper memberMapper = new MemberMapper();
		return jdbcTemplate.query(sql, memberMapper, params);
	}
	
	public MemberDto selectOne(String member_id) {
		String sql = "select * from member where member_id=?";
		Object[] params = {member_id};
		MemberMapper memberMapper = new MemberMapper();
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper,params);
			return list.isEmpty() ? null : list.get(0);
	}
	
	

}

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
	
	private Set<String> allowColumns = Set.of( 
					"member_id", "member_email",  "member_nickname", 
					"member_contact"
			);
	
	
	public void insert(MemberDto memberDto) {
		String sql = "insert into member("
				+ "member_id, member_email, member_password, member_nickname, "
				+ "member_birth, member_contact, member_post, member_address1, "
				+ "member_address2, member_message"
				+ ") "
				+ "values("
				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				memberDto.getMemberId(), memberDto.getMemberEmail(), 
				memberDto.getMemberPassword(), memberDto.getMemberNickname(), 
				memberDto.getMemberBirth(), memberDto.getMemberContact(), 
				memberDto.getMemberPost(), memberDto.getMemberAddress1(), 
				memberDto.getMemberAddress2(), memberDto.getMemberMessage()
				};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(MemberDto memberDto) {
		String sql = "update member "
				+ "set member_email=?, member_nickname=?, member_birth=?, "
				+ "member_contact=?, member_post=?, member_address1=?, "
				+ "member_address2=?, member_message=? "
				+ "where member_id = ? ";
		Object[] params = {
				memberDto.getMemberEmail(), memberDto.getMemberNickname(), 
				memberDto.getMemberBirth(), memberDto.getMemberContact(), 
				memberDto.getMemberPost(), memberDto.getMemberAddress1(), 
				memberDto.getMemberAddress2(), memberDto.getMemberMessage(), 
				memberDto.getMemberId()};
		return jdbcTemplate.update(sql, params) > 0 ;
	}
	public boolean delete(String memberId) {
		String sql = "delete member where member_id=?";
		Object[] params = {memberId};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
//	public List<MemberDto> selectList(){
//		String sql = "select * from member order by member_id asc";
//		MemberMapper memberMapper = new MemberMapper();
//		return jdbcTemplate.query(sql, memberMapper);
//	}
	
	public List<MemberDto> selectList(String column, String keyword){ 
		if(column == null || keyword == null) return List.of();
		if(column.isEmpty()||keyword.isEmpty()) return List.of();
		

		//질문: 가입날짜별로 조회는? 200포인트대 회원 조회는? 왜 문자열로만 조회하나? 
		if(!allowColumns.contains(column)) return List.of();
		String sql = "select * from member "
				+ "where instr( "+column+", ?) >0 and member_level != '마스터' "
						+ "order by "+column+" asc, member_id asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, memberMapper, params);
	}
	
	public MemberDto selectOne(String memberId) {
		String sql = "select * from member where member_id=?";
		Object[] params = {memberId};
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper,params);
			return list.isEmpty() ? null : list.get(0);
	}
	public MemberDto selectOneByMemberNickname(String memberNickname) {
		String sql = "select * from member where member_nickname=?";
		Object[] params = {memberNickname};
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, params);
			return list.isEmpty() ? null : list.get(0);
	}
	public MemberDto selectOneByMemberEmail(String memberEmail) {
		String sql = "select * from member where member_email=?";
		Object[] params = {memberEmail};
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, params);
			return list.isEmpty() ? null : list.get(0);
	}
	public boolean updateMemberLogin(String memberId) {
		String sql = "update member "
				+ "set member_login=systimestamp "
				+ "where member_id = ?";
		Object[] params = {memberId};
	    return jdbcTemplate.update(sql, params)>0;
	}
	
//	public boolean updateMemberPassword(String memberId, String changePw) {
		public boolean updateMemberPassword(MemberDto memberDto) {
		String sql = "update member "
				+ "set member_password= ?, member_change=systimestamp "
				+ "where member_id = ?";
		Object[] params = {memberDto.getMemberPassword(), memberDto.getMemberId()};
		return jdbcTemplate.update(sql, params)>0;
	}
		public boolean updateByMaster(MemberDto memberDto) {
			String sql = "update member "
					+ "set member_email=?, member_nickname=?, member_birth=?, "
					+ "member_contact=?, member_post=?, member_address1=?, "
					+ "member_address2=?, member_level=?, member_point=?, member_message=? "
					+ "where member_id=? ";
			Object[] params = {memberDto.getMemberEmail(), memberDto.getMemberNickname(), 
					memberDto.getMemberBirth(), memberDto.getMemberContact(), 
					memberDto.getMemberPost(), memberDto.getMemberAddress1(), 
					memberDto.getMemberAddress2(), memberDto.getMemberLevel(), 
					memberDto.getMemberPoint(), memberDto.getMemberMessage(), 
					memberDto.getMemberId() };
			return jdbcTemplate.update(sql, params)>0;
		}
		public void block(String memberId) {
			 String sql = "update member set member_block = 'Y' where member_id = ?";
			 Object[] params = {memberId};
			    jdbcTemplate.update(sql, params);
		}

		public void unblock(String memberId) {
			 String sql = "update member set member_block = 'N' where member_id = ?";
			 Object[] params = {memberId};
			    jdbcTemplate.update(sql, params);
		}
		public void connect(String memberId, int attachNo) {
			String sql = "insert into member_profile(member_id, attach_no) "
					+ "values(?, ?)";
			Object[] params = {memberId, attachNo};
			jdbcTemplate.update(sql, params);
			
		}
		public int searchProfile(String memberId) {
			String sql = "select attach_no from member_profile "
						+ "where member_id =?";
			Object[] params = {memberId};
			return jdbcTemplate.queryForObject(sql, int.class, params);
		}
		
		
		
		
		
		
		
		
		
		
		
	

}

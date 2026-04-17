package com.kh.spring09.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.mapper.BoardMapper;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BoardMapper boardMapper;
	
	private Set<String> allowColumns = Set.of(
			"board_title", "board_writer"
			);
	public List<BoardDto> selectList(){
		String sql = "select * from board order by board_wtime desc";
		return jdbcTemplate.query(sql, boardMapper);
	}
			
	
	public List<BoardDto> selectList(String column, String keyword){
		if(column == null || keyword == null) return selectList();
		
		if(!allowColumns.contains(column)) return List.of();
		
		String sql = "select * from board "
				+ "where instr("+column+", ?) >0 order by board_wtime desc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, boardMapper, params);
	}
	public BoardDto selectOne(int boardNo) {
		String sql = "select * from board where board_no = ?";
		Object[] params = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
	public boolean update(BoardDto boardDto) {
		String sql="update board "
				+ "set board_title=?, board_content=?, board_etime=systimestamp "
				+ "where board_no =?";
		Object[] params = {
				boardDto.getBoardTitle(), boardDto.getBoardContent(), 
				boardDto.getBoardNo() 
		};
		return jdbcTemplate.update(sql, params)>0;
	}
	public boolean insert(BoardDto boardDto) {
		String sql = "insert into board(board_no, board_title, board_content, "
				+ "board_writer"
				+ ") values( board_seq.nextval, ?, ?, ?"
				+ ")";
		Object[] params = {
				boardDto.getBoardTitle(), boardDto.getBoardContent(), 
				boardDto.getBoardWriter() 
		};
		return jdbcTemplate.update(sql, params)>0;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

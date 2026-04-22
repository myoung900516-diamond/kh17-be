package com.kh.spring09.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.kh.spring09.Spring09integrateApplication;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.mapper.BoardMapper;
import com.kh.spring09.vo.PageVO;

@Repository
public class BoardDao {

    private final Spring09integrateApplication spring09integrateApplication;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BoardMapper boardMapper;
	
	private Set<String> allowColumns = Set.of(
			"board_title", "board_writer"
			);

    BoardDao(Spring09integrateApplication spring09integrateApplication) {
        this.spring09integrateApplication = spring09integrateApplication;
    }
	
	public List<BoardDto> selectList(){
		String sql = "select * from board_list order by board_no desc";
		return jdbcTemplate.query(sql, boardMapper);
	}
//	public List<BoardDto> selectList(int page, int size){
//		String sql = "select * from ( "
//							+ "select rownum rn, TMP.* from( "
//									+ "select * from board_list order by board_no desc "
//							+ ")TMP "
//						+ ")where rn between ? and ?";
//		int beginRow = page*size - (size-1);
//		int endRow = page*size;
//		Object[] params = {beginRow, endRow};
//		
//		select * from (
//				select rownum rn, TMP.* from(
//						내가 원하는 데이터 조회 구문
//						)TMP
//				)where rn between ? and ?
//		return jdbcTemplate.query(sql, boardMapper, params);
//	}

	
	//트리정렬
	public List<BoardDto> selectList(int page, int size){
	String sql = "select * from ( "
						+ "select rownum rn, TMP.* from( "
								+ "select * from board_list "
								+ "connect by prior board_no=board_parent "
								+ "start with board_parent is null "
								+ "order siblings by board_group desc, board_no asc "
						+ ")TMP "
					+ ")where rn between ? and ?";
	int beginRow = page*size - (size-1);
	int endRow = page*size;
	Object[] params = {beginRow, endRow};
	

	return jdbcTemplate.query(sql, boardMapper, params);
}

			
	
//	public List<BoardDto> selectList(String column, String keyword){
//		if(column == null || keyword == null) return selectList();
//		
//		if(!allowColumns.contains(column)) return selectList();
//		
//		String sql = "select * from board_list "
//				+ "where instr("+column+", ?) >0 order by board_wtime desc";
//		Object[] params = {keyword};
//		return jdbcTemplate.query(sql, boardMapper, params);
//	}
	
//	public List<BoardDto> selectList(String column, String keyword, int page, int size){
//		if(column == null || keyword == null) return selectList(page, size);
//		
//		if(!allowColumns.contains(column)) return selectList(page, size);
//		
//		String sql = "select * from ( "
//				+ "select rownum rn, TMP.* from( "
//				+ "select * from board_list "
//				+ "where instr("+column+", ?) >0 order by board_wtime desc"
//						+ ")TMP "
//						+ ")where rn between ? and ?";
//		int beginRow = page*size - (size-1);
//		int endRow = page*size;
//		Object[] params = {keyword, beginRow, endRow};
		
//		select * from (
//		select rownum rn, TMP.* from(
//				내가 원하는 데이터 조회 구문
//				)TMP
//		)where rn between ? and ?
		
//		return jdbcTemplate.query(sql, boardMapper, params);
//	}
	
	//트리정렬
	public List<BoardDto> selectList(PageVO pageVO){
		if(pageVO.isList())
			return selectList(pageVO.getPage(), pageVO.getSize());
		
		if(!allowColumns.contains(pageVO.getColumn())) 
			return selectList(pageVO.getPage(), pageVO.getSize());
		
		String sql = "select * from ( "
				+ "select rownum rn, TMP.* from( "
				+ "select * from board_list "
				+ "where instr("+pageVO.getColumn()+", ?) >0 "
						+ "connect by prior board_no=board_parent "
						+ "start with board_parent is null "
						+ "order siblings by board_group desc, board_no asc "
						+ ")TMP "
						+ ")where rn between ? and ?";
//		int beginRow = page*size - (size-1);
//		int endRow = page*size;
		Object[] params = {pageVO.getKeyword(), 
								pageVO.getBeginRownum(), 
								pageVO.getEndRownum()};
		return jdbcTemplate.query(sql, boardMapper, params);
	}
		
	
	public List<BoardDto> selectNoticeList(){
		String sql = "select * from board_list where board_head = '공지' order by board_no desc";
		return jdbcTemplate.query(sql, boardMapper);
	}
	
	public BoardDto selectOne(long boardNo) {
		String sql = "select * from board where board_no = ?";
		Object[] params = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
	//이전글 정보
	public BoardDto selectPreviousOne(long boardNo) {
		String sql = "select * from board where board_no = ("
						+ "select max(board_no) from board where board_no < ?"
						+ ")";
		Object[] params = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
	
	public BoardDto selectNextOne(long boardNo) {
		String sql = "select * from board where board_no = ("
				+ "select min(board_no) from board where board_no > ?"
				+ ")";
		Object[] params = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
	public List<BoardDto> selectListByBoardWriter(String boardWriter) {
		String sql = "select * from board_list where board_writer=? "
						+ "order by board_no desc";
		Object[] params = {boardWriter};
		return jdbcTemplate.query(sql, boardMapper, params);
	}
	public boolean update(BoardDto boardDto) {
		String sql="update board "
				+ "set board_title=?, board_head=?, board_content=?, board_etime=systimestamp "
				+ "where board_no =?";
		Object[] params = {
				boardDto.getBoardTitle(), boardDto.getBoardHead(), boardDto.getBoardContent(), 
				boardDto.getBoardNo() 
		};
		return jdbcTemplate.update(sql, params)>0;
	}
	//시퀀스 번호 생성을 먼저하고 등록을 나중에 
	public long sequence() {
		String sql = "select board_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, long.class);
	}
	
//	public void insert(BoardDto boardDto) {
//		String sql = "insert into board(board_no, board_head, board_title, board_content, "
//				+ "board_writer"
//				+ ") values( ?, ?, ?, ?, ?"
//				+ ")";
//		Object[] params = {
//				boardDto.getBoardNo(), 
//				boardDto.getBoardHead(), boardDto.getBoardTitle(), 
//				boardDto.getBoardContent(), 
//				boardDto.getBoardWriter() 
//		};
//		jdbcTemplate.update(sql, params);
//	}
	public void insert(BoardDto boardDto) {
		String sql = "insert into board(board_no, board_head, board_title, board_content, "
				+ "board_writer, board_group, board_parent, board_depth "
				+ ") values( ?, ?, ?, ?, ?, ?, ?, ? "
				+ ")";
		Object[] params = {
				boardDto.getBoardNo(), 
				boardDto.getBoardHead(), boardDto.getBoardTitle(), 
				boardDto.getBoardContent(), 
				boardDto.getBoardWriter(), boardDto.getBoardGroup(), 
				boardDto.getBoardParent(), boardDto.getBoardDepth() 
		};
		jdbcTemplate.update(sql, params);
	}
	public boolean delete(long boardNo) {
		String sql="delete board where board_no =?";
		Object[] params = {boardNo};
		return jdbcTemplate.update(sql, params)>0;
	}
	public boolean updateBoardReadcount(long boardNo) {
		String sql="update board "
				+ "set board_readcount = board_readcount + 1 "
				+ "where board_no = ?";
		Object[] params = {boardNo};
		return jdbcTemplate.update(sql, params)>0;
	}

	//목록과 검색의 상황별 카운트 메소드
	//-> 화면에서 마지막 페이지가 어딘지 알기 위해 필요한 데이터
	public int count() {
		String sql= "select count(*) from board";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
//	public int count(String column, String keyword) {
//		if(column == null || keyword == null) return count();
//		
//		String sql = "select count(*) from board where instr("+column+", ?) >0 ";
//		Object[] params = {keyword};
//		return jdbcTemplate.queryForObject(sql, int.class, params);
//	}
	public int count(PageVO pageVO) {
		if(pageVO.isList()) return count();
		if(!allowColumns.contains(pageVO.getColumn())) return count();
		
		String sql = "select count(*) from board where instr("+pageVO.getColumn()+", ?) >0 ";
		Object[] params = {pageVO.getKeyword()};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

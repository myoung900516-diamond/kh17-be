package kh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import kh.dto.MusicDto;
import kh.mapper.MusicMapper;
import kh.util.JdbcUtils;

public class MusicDao {
	public void insert(MusicDto musicDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		
		String sql = "insert into music("
				+ "music_id, music_title, music_artist, music_album, music_release, "
				+ "music_play, music_like, music_dislike, music_genre "
				+ ")"
				+ "values(music_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				musicDto.getMusicTitle(), musicDto.getMusicArtist(), musicDto.getMusicAlbum(), 
				musicDto.getMusicRelease(), musicDto.getMusicPlay(), musicDto.getMusicLike(), 
				musicDto.getMusicDislike(), musicDto.getMusicGenre()
		};
		jdbcTemplate.update(sql, params);
		
	}
	
	public boolean update(MusicDto musicDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "update music"
				+ "set music_title =?, music_artist=?, music_album=?, "
				+ "music_release=?, "
				+ "music_play=?, music_like=?, music_dislike=?, music_genre=?"
				+ "where music_id=?";
		Object[] params = {
				musicDto.getMusicTitle(), musicDto.getMusicArtist(), musicDto.getMusicAlbum(),
				musicDto.getMusicRelease(), musicDto.getMusicPlay(), musicDto.getMusicLike(),
				musicDto.getMusicDislike(), musicDto.getMusicGenre(), musicDto.getMusicId() 
		};
		int rows = jdbcTemplate.update(sql, params);
		return rows >0; 
	}
	
	public boolean delete(int musicId) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "delect music where music_id=? ";
		Object[] params = {musicId};
		return jdbcTemplate.update(sql, params)>0;
	}
	
	public List<MusicDto> selectList(){
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from music order by music_id asc";
		MusicMapper musicMapper = new MusicMapper();
		return jdbcTemplate.query(sql, musicMapper);
	}
	
	public List<MusicDto> selectList(String column, String keyword){
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from music where instr("+column+", ?) > 0 order by music_id asc";
		Object[] params = {keyword};
		MusicMapper musicMapper = new MusicMapper();
		return jdbcTemplate.query(sql, musicMapper, params);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

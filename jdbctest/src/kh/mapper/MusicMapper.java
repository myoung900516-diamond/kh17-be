package kh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kh.dto.MusicDto;

public class MusicMapper implements RowMapper<MusicDto>{

	@Override
	public MusicDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MusicDto musicDto = new MusicDto();
		musicDto.setMusicId(rs.getInt("music_id"));
		musicDto.setMusicTitle(rs.getString("music_title"));
		musicDto.setMusicArtist(rs.getString("music_album"));
		musicDto.setMusicAlbum(rs.getString("music_album"));
		musicDto.setMusicRelease(rs.getString("music_release"));
		musicDto.setMusicPlay(rs.getLong("music_play"));
		musicDto.setMusicLike(rs.getLong("music_like"));
		musicDto.setMusicDislike(rs.getLong("music_dislike"));
		musicDto.setMusicGenre(rs.getString("music_genre"));
		return musicDto;
	}

}

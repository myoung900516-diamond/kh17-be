package jdbc.select;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LectureMapper implements RowMapper<LectureDto> {

	@Override
	public LectureDto mapRow(ResultSet rs, int idx) throws SQLException {
		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureNo(rs.getInt("lecture_no"));
		lectureDto.setLectureTitle(rs.getString("lecture_title"));
		lectureDto.setLectureCategory(rs.getString("lecture_category"));
		lectureDto.setLectureDuration(rs.getInt("lecture_duration"));
		lectureDto.setLecturePrice(rs.getInt("lecture_price"));
		lectureDto.setLectureType(rs.getString("lecture_type"));
		
		return lectureDto;
	}

}

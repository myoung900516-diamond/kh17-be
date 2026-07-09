package com.kh.spring11.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(description = "강좌 부분 수정정보")
@Data
public class LectureUpdateUnitVO {
	@Schema(description = "강좌제목", example = "정보처리기사 필기")
	private String lectureTitle;
	@Schema(description = "강좌분류", examples = {"이론", "실습", "시험"})
	private String lectureCategory;
	@Schema(description = "강의시간", example = "30")
	private Integer lectureDuration;
	@Schema(description = "강의료", example = "1000")
	private Integer lecturePrice;
	@Schema(description = "강좌형태", examples = {"온라인", "오프라인", "혼합"})
	private String lectureType;

}

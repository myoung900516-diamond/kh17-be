package com.kh.spring11.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "도서 부분 수정 정보")
@Data
public class BookUpdateUnitVO {

	@Schema(description="도서제목", example="젊은 베르테르의 슬픔")
	private String bookTitle;
	@Schema(description="지은이", example="괴테")
	private String bookAuthor;
	@Schema(description="출판일", example="1996-07-16")
	private String bookPublicationDate;
	@Schema(description="도서가", example="18000")
	private int bookPrice;
	@Schema(description="출판사", example="열린책들")
	private String bookPublisher;
	@Schema(description="페이지수", example="256")
	private int bookPageCount;
	@Schema(description="장르", example="소설")
	private String bookGenre;

}

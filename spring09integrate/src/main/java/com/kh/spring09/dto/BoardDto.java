package com.kh.spring09.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class BoardDto {
	private int boardNo;
	private String boardHead;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Timestamp boardWtime;
	private Timestamp boardEtime;
	private int boardReadcount;
	private int boardLikecount;
	private int boardReplycount;
	
	public String getBoardWtimeString() {
	    if(boardWtime == null) return "";

	    LocalDateTime wtime = boardWtime.toLocalDateTime();

	    LocalDate today = LocalDate.now();
	    LocalDate writeDate = wtime.toLocalDate();

	    if(writeDate.equals(today)) {
	        return wtime.format(DateTimeFormatter.ofPattern("HH:mm"));
	    } else {
	        return wtime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    }
	}
}




















package com.kh.spring09.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class BoardDto {
	private long boardNo;
	private String boardHead;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Timestamp boardWtime;
	private Timestamp boardEtime;
	private long boardReadcount;
	private long boardLikecount;
	private long boardReplycount;
	
	private long boardGroup;
	private Long boardParent;//null 가능
	private long boardDepth;
	
	public String getBoardWtimeString() {
//	    if(boardWtime == null) return "";
	    	//작성일을 localdatetime형태로 불러온다 
	    LocalDateTime writetime = boardWtime.toLocalDateTime();

	    LocalDate today = LocalDate.now();
	    LocalDate writeDate = writetime.toLocalDate();
//	    System.out.println(today);
//	    System.out.println(writeDate);
	    System.out.println(writetime);

	    if(writeDate.equals(today)) {
	        return writetime.format(DateTimeFormatter.ofPattern("HH:mm"));
	    } else {
	        return writetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    }
	    
	}
}




















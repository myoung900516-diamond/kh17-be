package com.kh.spring09.dto;

import java.sql.Timestamp;

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
}

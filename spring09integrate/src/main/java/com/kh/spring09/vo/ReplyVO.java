package com.kh.spring09.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ReplyVO {
	
	private long replyNo;
	private String replyWriter;
	private long replyOrigin;
	private String replyContent;
	private Timestamp replyWtime;
	private Timestamp replyEtime;
	
	private boolean writer; //이 값이 true면 작성자가 쓴 댓글이라는 의미(작성자라는 표시가 추가됨)
	
	private boolean owner; //이 값이 true면 본인이 쓴 댓글이라는 의미(수정/삭제 가능)

}

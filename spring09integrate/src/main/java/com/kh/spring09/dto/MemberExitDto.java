package com.kh.spring09.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberExitDto {
	private String memberId;
	private String memberEmail;
	private String memberPassword;
	private String memberNickname;
	private String memberBirth;
	private String memberContact;
	private String memberPost;
	private String memberAddress1;
	private String memberAddress2;
	private String memberLevel;
	private String memberMessage;
	private Timestamp memberJoin;
	private Timestamp memberLogin;
	private Timestamp memberChange;
	private String memberBlock;
	private int memberPoint;
	private Timestamp memberExitTime;
	
	//컨트롤러 코드의 가독성을 높이기 위한 
	public boolean isWaitForDelete() {
		return memberExitTime != null;
	}
}
	

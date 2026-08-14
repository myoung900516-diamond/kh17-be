package com.kh.spring11.vo.message;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChatMessageVO extends MessageVO{
	private int messageNo;
	private String messageSenderId;
	private String messageSenderLevel;
	private String messageSenderNickname;
}

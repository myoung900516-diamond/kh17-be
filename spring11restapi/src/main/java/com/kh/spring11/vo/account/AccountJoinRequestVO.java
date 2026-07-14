package com.kh.spring11.vo.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

//회원가입 요청용 VO
//회원가입하려면 무슨 정보가 필요한가
//차이를 계속 인지하자 
@Schema(name= "회원가입 정보 객체")
@Data
public class AccountJoinRequestVO {
	
	private String accountId;
	private String accountEmail;
	private String accountPassword;
	private String accountNickname;
	private String accountBirth;
	private String accountContact;
	private String accountPost, accountAddress1, accountAddress2;
	private String accountMessage;
	
}

package com.kh.spring11.vo.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(name="비밀번호 변경 요청 VO")
//비밀번호 변경 요청 VO
@Data @JsonIgnoreProperties(ignoreUnknown = true)
//내가 적은거 말고 다른거 보내면 무시해 내가 명시한거 외에는 무시해라! 
public class ChangePasswordRequestVO {

//	private String accountId; 
	private String prevAccountPassword;
	private String newAccountPassword;
}

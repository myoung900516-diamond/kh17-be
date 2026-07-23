package com.kh.spring11.vo.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Schema(name="비밀번호 변경 응답VO")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ChangePasswordResponseVO {
	
	private boolean result; //true면 성공 false면 실패
	private String message; //상태 메세지 
	

}

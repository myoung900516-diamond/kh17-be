package com.kh.spring11.vo.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name="현재비밀번호조회응답용")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountPasswordFindResponseVO {
	private String accountId;
	private String accountPassword;
}

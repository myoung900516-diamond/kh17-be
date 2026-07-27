package com.kh.spring11.vo.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name="회원 차단 확인")
@Data @NoArgsConstructor @AllArgsConstructor
public class AccountBlockResponseVO {
	

	private boolean result; //true면 차단 "Y" false면 풀림 "N"
}

package com.kh.spring11.vo.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name="현재비밀번호조회요청용")
@Data
public class AccountPasswordFindRequestVO {
	private String accountPassword;

}

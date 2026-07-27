package com.kh.spring11.vo.cert;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name="임시비밀번호 전송 확인")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class CertTempPasswordResponseVO {
	private boolean result;

}

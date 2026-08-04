package com.kh.spring11.vo.kakaopay;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name="상품 구매 요청 결과 데이터")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class KakaopayBuyResponseVO {
	private String url;

}

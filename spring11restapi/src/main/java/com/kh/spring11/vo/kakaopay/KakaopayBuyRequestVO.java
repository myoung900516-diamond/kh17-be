package com.kh.spring11.vo.kakaopay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(name="상품 구매 요청 VO")
@Data @JsonIgnoreProperties(ignoreUnknown = true)
public class KakaopayBuyRequestVO {
	@NotNull
	private String name;
	@NotNull
	private int price;

}

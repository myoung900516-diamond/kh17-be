package com.kh.spring11.vo.purchase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Schema(name="장바구니 구현 요청정보")
@Data @JsonIgnoreProperties(ignoreUnknown = true)
public class CartAddRequestVO {
	@NotNull @Positive
	private int item;
	@NotNull @Positive
	private int qty;
	

}

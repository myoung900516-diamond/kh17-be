package com.kh.spring11.vo.kakaopay;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(name="상품 구매 요청 VO version2")
@Data @JsonIgnoreProperties(ignoreUnknown = true)
public class KakaopayBuyRequestVO2 {
	@NotEmpty
	private List<BuyVO> orders;
	

}

package com.kh.spring11.vo.kakaopay;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class KakaopayAmountVO {

	@JsonAlias("total")
	private Integer total;
	@JsonAlias("tax_free")
	private Integer taxFree;
	@JsonAlias("vat")
	private Integer vat;
	@JsonAlias("point")
	private Integer point;
	@JsonAlias("discount")
	private Integer discount;
	@JsonAlias("green_deposit")
	private Integer greenDeposit;
}

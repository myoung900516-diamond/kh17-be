package com.kh.spring11.vo.kakaopay;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data 
public class KakaopayPaymentActionDetail {
	@JsonAlias("aid")
	private String aid;//Request 고유번호
	@JsonAlias("approved_at")
	private LocalDateTime approvedAt;//거래시간
	@JsonAlias("amount")
	private Integer amount;//결제/취소 총액
	@JsonAlias("point_amount")
	private Integer pointAmount;
	@JsonAlias("discount_amount")
	private Integer discountAmount;
	@JsonAlias("green_deposit")
	private Integer greenDeposit;
	@JsonAlias("payment_action_type")
	private String paymentActionType;
	@JsonAlias("payload")
	private String payload;

}

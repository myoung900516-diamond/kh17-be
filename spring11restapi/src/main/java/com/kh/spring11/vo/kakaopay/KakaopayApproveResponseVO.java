package com.kh.spring11.vo.kakaopay;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class KakaopayApproveResponseVO {

	private String aid;//요청 고유번호
	private String tid;//결제 고유번호
	private String cid;//가맹점 코드
	private String sid;//정기결재용 ID(정기결제시에만 생김)
	private String partnerOrderId;//주문번호(가맨점내)
	private String partnerUserId;//주문자(가맹점내)
	private String paymentMethodType;//결제수단(CARD/MONEY)
	//amount
	private KakaopayAmountVO amount;
	//cardInfo
	private KakaopayCardInfoVO cardInfo;
	private String itemName;//상품명
	private String itemCode;//상품코드
	private Integer quantity;//상품수량
	private LocalDateTime createdAt;//생성시각
	private LocalDateTime approvedAt;//승인시각
	private String payload;//추가 요청사항
	
	//url
	//tid
	//createdAt
}

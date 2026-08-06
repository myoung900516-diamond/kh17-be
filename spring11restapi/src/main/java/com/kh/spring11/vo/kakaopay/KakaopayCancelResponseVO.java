package com.kh.spring11.vo.kakaopay;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data 
public class KakaopayCancelResponseVO {

	private String aid;//요청 고유번호
	private String tid;//결제 고유번호
	private String cid;//가맹점 코드
	private String status;//결제상태
	private String partnerOrderId;//가맹점 주문번호
	private String partnerUserId;//가맹점 회원id
	private String paymentMethodType;//결제수단, CARD 또는 MONEY
	private KakaopayAmountVO amount;//결제금액
	private KakaopayAmountVO approvedCancelAmount;//이번 요청으로 취소된 금액
	private KakaopayAmountVO canceledAmount;//누게 취소 금액
	private KakaopayAmountVO cancelAvailableAmount;//남은 취소 가능 금액
	private String itemName;//상품이름, 최대 100자
	private String itemCode;//상품코드, 최대100자
	private Integer quantity;//상품 수량
	private LocalDateTime createdAt;//결제준비요청시각
	private LocalDateTime approvedAt;//결제승인시각
	private LocalDateTime canceledAt;//결제 취소 시각
	private String payload;//취소 요청시 전달한 값
}

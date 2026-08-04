package com.kh.spring11.vo.kakaopay;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//Jackson의 @JsonNaming을 사용하여 해결 (변환 시 자동으로 바뀜)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class KakaopayReadyRequestVO {
	private String cid;
	private String partnerOrderId;
	private String partnerUserId;
	private String itemName;
	@Builder.Default
	private int quantity = 1;
	//int는 양수 한계가 21억
	private long totalAmount;
	private long taxFreeAmount;
	private String approvalUrl;
	private String cancelUrl;
	private String failUrl;
	
	
	

}

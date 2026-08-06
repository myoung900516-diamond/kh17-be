package com.kh.spring11.vo.kakaopay;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
//JsonNaming은 직렬화(serialize)와 역직렬화(deserialize)에 모두 관여
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
//->다음 둘 중 하나를 적어서 "수신"에만 적용되도록 구현
//@JsonAlias("별칭") -원래 이름 으로 받을 수 없는 경우 대체할 별칭을 부여
//@JsonSetter("이름") -원래 이름 대신 사용할 이름을 지정
//->이 어노테이션들은 역직렬화(수신)에만 관여한다

@Data 
//@Builder @NoArgsConstructor @AllArgsConstructor
public class KakaopayOrderResponseVO {
	
	//접근제한자를 안씀 귀찮아서 안쓰면 package안에서만 쓸 수 있어서 사실상 접근제한이 되기 때문이다. 
	
	
	@JsonAlias("tid")
	private String tid;//결제고유번호
	@JsonAlias("cid")
	private String cid;//가맹점 코드
	@JsonAlias("status")
	private String status;//결제 상태
	@JsonAlias("partner_order_id")
	private String partnerOrderId;//가맹점 내 주문번호
	@JsonAlias("partner_user_id")
	private String partnerUserId;//가맹점 내 주문자아이디
	@JsonAlias("payment_method_type")
	private String paymentMethodType;//결제 수단(Card or  money)
	//amount
	@JsonAlias("amount")
	private KakaopayAmountVO amount;//결제금액
	@JsonAlias("canceldAmount")
	private KakaopayAmountVO canceledAmount;
	@JsonAlias("canceled_available_amount")
	private KakaopayAmountVO canceledAvailableAmount;

	@JsonAlias("item_name")
	private String itemName;//상품 이름
	@JsonAlias("item_code")
	private String itemCode;//상품 코드
	@JsonAlias("quatity")
	private Integer quantity;//상품수량(1로 고정)
	@JsonAlias("created_at")
	private LocalDateTime createdAt; //다받아줌. //결제시작시간
	@JsonAlias("approved_at")
	private LocalDateTime approvedAt;//결제승인시간
	@JsonAlias("canceled_at")
	private LocalDateTime canceledAt;//결제 취소시간
	//cardInfo
	@JsonAlias("selected_card_info")
	private KakaopaySelectedCardInfoVO SelectedCardInfo;
	@JsonAlias("payment_action_details")
	private List<KakaopayPaymentActionDetail> paymentActionDetails;//결제 상세내역
//	private KakaopayPaymentActionDetail[] paymentActionDetails;
	//둘중 하나를 쓰면 됨 둘중 됨. 배열은 조회가 빠름 list는 사용이 쉬움
	//selectedCardInfo
	//paymentActionDetails

}

package com.kh.spring11.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.kh.spring11.vo.kakaopay.KakaopayReadyResultVO;

//임시 데이터를 저장하기 위한 서비스
@Service
public class FlashService {

	//Map에 데이터를 저장해두고 이를 이름으로 찾아갈 수 있도록 처리
	//-이름을 뭘로 할 것인가? String partnerOrderId
	//-값을 뭘로 할 것인가? KakaopayReadyResultVO(partnerOrderId, partnerUserId, tid)
	
	//저장소 생성(둘 다 가능)
//	private Map<String, KakaopayReadyResultVO> kakaopayReadyFlashMap = Collections.synchronizedMap(new HashMap<>());
	
	private Map<String, KakaopayReadyResultVO> kakaopayReadyFlashMap = new ConcurrentHashMap<>();//업캐스팅
	
	public void addKakaopayReadyFlashData(KakaopayReadyResultVO result) {
		kakaopayReadyFlashMap.put(result.getPartnerOrderId(), result);
	}
	
	public KakaopayReadyResultVO getKakaopayReadyFlashData(String partnerOrderId) {
		return kakaopayReadyFlashMap.remove(partnerOrderId); //get은 그냥 꺼내기만 하고 remove는 지우면서 꺼냄. 
	}
	
}

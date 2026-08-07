package com.kh.spring11.dao;

import java.util.List;

import com.kh.spring11.dto.PurchaseDetailDto;
import com.kh.spring11.dto.PurchaseDto;
//인터페이스는 public이 자동으로 붙음 
public interface PurchaseDao {
	int purchaseSequence();
	void purchaseInsert(PurchaseDto purchaseDto);
	
	int purchaseDetailSequence();
	void purchaseDetailInsert(PurchaseDetailDto purchaseDetailDto);
	
	PurchaseDto selectOne(int purchaseNo);
	List<PurchaseDetailDto> selectDetails(int purchaseNo);
	boolean purchaseDetailCancel(int purchaseDetailOrigin);
	
	boolean purchaseCancel(int purchaseNo);
	PurchaseDetailDto selectDetailOne(int purchaseDetailNo);
	
	
	boolean purchaseCancelUnit(int purchaseNo, int amount);
	boolean purchaseDetailCancelUnit(int purchaseDetailNo);

}

package oop.methodanswer;

public class PrintService {
	
	//멤버 필드
	String partName;
	String partCategory;
	int makeDuration;
	int unitPrice;
	String deliveryType;
	
	//세터 메소드
	void setPartName(String partName) {
		if(partName.length() > 20)return;//글자수 제한걸기 
		this.partName = partName;
	}
	void setPartCategory(String partCategory) {
		switch(partCategory) {
		case "재료", "소모품", "부품", "출력":
			this.partCategory = partCategory;
		}
	}
	void setMakeDuration (int makeDuration) {
		if(makeDuration <0)return;
		if(makeDuration % 24 != 0 )return;
		this.makeDuration = makeDuration;
	}
	void setUnitPrice(int unitPrice) {
		if(unitPrice < 0)return;
		if(unitPrice % 1000 != 0)return;
		this.unitPrice = unitPrice;	
	}
	void setDeliveryType(String deliveryType) {
		switch(deliveryType) {
		case "일반", "퀵", "방문수령":
			this.deliveryType = deliveryType;
		}
		
	}
	
	//멤버 메소드
	void init(String partName, String partCategory, int makeDuration, int unitPrice, String deliveryType) {
		this.partName = partName;//필드에 데이터를 대입하는 코드
		this.setPartName(partName);//메소드를 호출하면서 값을 전달하는 코드
		this.setMakeDuration(makeDuration);
		this.setUnitPrice(unitPrice);
		this.setDeliveryType(deliveryType);
	}
	void show() {
		System.out.println("<" + this.partName + ">");
		System.out.println("분류 : " + this.partCategory);
		System.out.println("제작 소요시간 : " + this.makeDuration + "분");
		System.out.println("단가 : " + this.unitPrice + "원");
		System.out.println("배송방식 : " + this.deliveryType);
		
	}
	

}

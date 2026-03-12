package oop.methodanswer;

public class Test013D프린터상품목록 {
	public static void main(String[] args) {
		PrintService p1 = new PrintService();
		PrintService p2 = new PrintService();
		PrintService p3 = new PrintService();
		PrintService p4 = new PrintService();
		
		
		//객체 초기화
		
		p1.init("고강도 PLA 필라멘트", "재료", 24, 25000, "일반");
		p2.init("노즐 세트", "소모품", 48, 15000, "퀵");
		p3.init("출력물 전용 베드", "부품", 72, 45000, "일반");
		p4.init("맞춤형 출력물 제작", "출력", 120, 100000, "방문수령");
		
		p1.show();
		p2.show();
		p3.show();
		p4.show();
	
		
	}
}

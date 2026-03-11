package oop.method7;

public class Test013D프린터업체서비스과제 {
	public static void main(String[] args) {
		Service s1 = new Service();
		Service s2 = new Service();
		Service s3 = new Service();
		Service s4 = new Service();
		
		s1.init("고강도 PLA 필라멘트", "재료", 0, 25000, "일반");
		s2.init("노즐 세트", "소모품", 48, 15000, "퀵");
		s3.init("출력물 전용 베드", "부품", 72, 45000, "일반");
		s4.init("맞춤형 출력물 제작", "출력", 120, 100000, "방문수령");
		
		s1.show();
		s2.show();
		s3.show();
		s4.show();
	
		
	}

}

package oop.method9다시풀기;


public class Test01인적사항 {
	public static void main(String[] args) {
		
	
	Members m1 = new Members();
	Members m2 = new Members();
	Members m3 = new Members();
	Members m4 = new Members();
	
	m1.init("마리오", "학생", 15, 160, 51);
	m2.init("루이지", "개발자", 22, 180, 75);
	m3.init("피오나", "디자이너", 20, 162, 50);
	m4.init("쿠파", "기획자", 30, 190, 95);
	
	
	m1.show();
	m2.show();
	m3.show();
	m4.show();
	
	}
}

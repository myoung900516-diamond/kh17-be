package oop.method4answer2;

public class Test01상품정보생성 {
	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		Product p4 = new Product();
		
		//p1.init("비김면", "라면", 16800, 2, 0, true);
		p1.init("비김면", "라면", 16800, 2, true);//할인율을 언급하지 않음
		p2.init("크림대빵", "제과", 6500, 2);//학인율과 새벽배송을 언급하지 않음
		p3.init("점보도시락", "라면", 8500, 3, 5, true);//전부다 언급을 해야하는 상황
		p4.init("공간춘", "라면", 12300, 5, 20);//새벽배송을 언급하지 않음
		
		p1.show();
		p2.show();
		p3.show();
		p4.show();
	}

}

package oop.basic4;

public class Test01메소드의필요성 {
	public static void main(String[] args) {
		
		
		//객체 생성
		Student a = new Student();
		Student b = new Student();
		
		//객체 초기화 
		a.init("김지향", 100);//a를 주인공으로 해서 init에 저장된 코드를 실행하며 "김지향", 100을 순서대로 넘겨라 
		b.init("장보고", 80);//b를 주인공으로 해서 init에 저장된 코드를 실행하며 "장보고", 80을 순서대로 넘겨라 
//		a.name = "김지향";
//		a.score = 100;
//		
//		a.name = "장보고";
//		a.score = 80;
		
		//객체 정보 출력 
		
		a.show(); //a를 주인공으로해서 show에 저장된 코드를 실행해라!
		b.show();//b를 주인공으로해서 show에 저장된 코드를 실행해라!
		
//		System.out.println(a.name);
//		System.out.println(a.score);
//		
//		System.out.println(b.name);
//		System.out.println(b.score);
		
		
	}

}

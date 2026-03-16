package oop.keyword2;

//클래스로 간편한 계산을 하기 위해 노력
//-클래스 코드의 대부분은 필드 때문에 생긴다(생성자, setter, getter)
//필드 없이?!
//-필드 없이 일회용 메소드만으로 구현
public class Triangle {
	
//	public double getArea(int width, int height) {
//		return width * height / 2;
//	}

	//아예 객체 없이 접근 가능하도록 정적(static) 처리 구현 
	//static이 붙은 애들은 클래스가 껍데기 
	//객체에 포함되지 않고 독립적으로 사용 가능한 메소드 
	public static double getArea(int width, int height) {
		return width * height / 2;
	}
}

package oop.keyword1;

public class Test01객체지향의문제점 {
	public static void main(String[] args) {
		//삼각형의 넓이를 구하는 코드 
		//밑변이 5, 높이가 3
		
		int w = 5;
		int h =3;
		double area = w * h / 2.0;
		System.out.println("area = " + area);
		
		Triangle triangle = new Triangle(w, h);
		System.out.println("area = " + triangle.getArea());
	}

}

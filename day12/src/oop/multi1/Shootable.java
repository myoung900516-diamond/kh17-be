package oop.multi1;

//부가속성으로 사용할 클래서(다중상속용 클래스)
//-다중상속에서 문제되는 요소가 모두 제거된 클래스
//-사실상 "추상 메소드"외에는 사용이 불가능하다. 필드, 생성자 만들지 못함. 
public interface Shootable {//촬영이 가능한 = shootable
	/*public abstract(생략가능)*/ void shoot();//촬영기능 

}

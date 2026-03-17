package api.object;

import java.util.Random;
import java.util.Scanner;

public class Test02아무거나 {
	public static void main(String[] args) {
		//Object를 이용하면 "아무거나"라는 개념을 구현할 수 있다
		//자바에 존재하는 모든 데이터를 "보관"할 수 있다. 
		//Object를 상속받지 않는 애들이 없다. 
		//서로 다른 "   "을 하나로 묶는다는 장점 
		Object a = "hello"; //*** String이 Object로 업캐스팅 *** 상속받으면 업캐스팅 된다. 원본은 그대로고 보관되는 형식이 바뀐다. 휴대폰이 락커룸(object)에 갖혀있다. 휴대폰은 달라지지 않음
		Object b = 100; // int(정확히는 integer) 가 Object로 업캐스팅
		Object c = new Scanner(System.in); //Scanner -> Object 업캐스팅 
		Object d = new Random(); // Random -> Object 업캐스팅 
		Object e = new int[] { 10,20,30,40,50,}; //int -> Object 업캐스팅
		Object f = false; //boolean(Boolean) -> Object 업캐스팅
 		
		//내가 만든 클래스는 이 아무거나에 포함되는가? 
		Student s = new Student();
		System.out.println(s.hashCode());
		System.out.println(s.toString());
		
		//Object 클래스의 기본메소드 + 아무거나 를 대신하는 역할 + Object가 없으면 모든 자료형을 다 써야하지만 
	}

}

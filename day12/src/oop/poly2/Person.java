package oop.poly2;


//사람
public class Person extends Teacher {

	public void explain() {
		System.out.println("어떤 내용을 설명합니다");
	}

	public void exam() {
		System.out.println("시험 문제를 준비합니다");
	}

	public void drink() {
		System.out.println("술을 마십니다.");
	}
	public void sing() {
		System.out.println("신나게 노래를 부릅니다");
	}
}

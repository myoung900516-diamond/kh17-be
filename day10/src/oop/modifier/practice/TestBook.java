package oop.modifier.practice;

public class TestBook { 
	public static void main(String[] args) {
		
	Book b1 = new Book("자바의 정석", "기술", 1000, 5000, true);
	Book b2 = new Book("어린왕자", "소설", 150, 2000, false);
	Book b3 = new Book("노인과 바다", "소설", 200, 2500, true);
	Book b4 = new Book("SQL 기초", "기술", 400, 4500, false);
	
	
	b1.show();
	b2.show();
	b3.show();
	b4.show();
	
	}

}

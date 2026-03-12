package oop.constructor2;

public class Test01캐릭터정보 {
	public static void main(String[] args) {
		Player u1 = new Player("테스트유저1", "전사", 88, 1000000);
		Player u2 = new Player("테스트유저2", "마법사", 50, 500000);
		Player u3 = new Player("테스트유저3", "궁수", 1, 0);
		
		u1.show();
		u2.show();
		u3.show();
		
	}

}

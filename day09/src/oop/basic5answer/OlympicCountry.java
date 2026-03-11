package oop.basic5answer;

public class OlympicCountry {
	
	int rank;
	String name;
	int gold, silver, bronze;
	
	//멤버 메소드 : 필요 기능 코드 저장 
	//-init 메소드 : 
	void init(int rank, String name, int gold, int silver, int bronze ) {//준비물(매개변수)
		this.rank = rank;
		this.name = name;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
		
	void show() {
		System.out.println("<참여국가정보>");
		System.out.println("순위 : " + this.rank);
		System.out.println("이름 : " + this.name);
	    System.out.println("금" + this.gold + ",은" + this.silver + ",동" + this.bronze);

	int total = this.gold + this.silver + this.bronze;
	System.out.println("총" + total + "개");
	}

}


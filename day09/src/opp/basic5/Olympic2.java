package opp.basic5;

public class Olympic2 {
	
	int rank;
	String nation;
	int gold;
	int silver;
	int bronze;
	int total;
	
	void init(int rank, String nation, int gold, int silver, int bronze) {
		this.rank = rank;
		this.nation = nation;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
		//this.total = total;
	}
	
	void show() {
		
		System.out.println("순위 : " + this.rank);
		System.out.println("국가 : " + this.nation);
		System.out.println("금메달 : " + this.gold);
		System.out.println("은메달 : " + this.silver);
		System.out.println("동메달 : " + this.bronze);
		System.out.println("총 메달 : " + this.total);
		System.out.println();
		
	}

}

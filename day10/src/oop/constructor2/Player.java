package oop.constructor2;

public class Player {
	
	private String id;
	private String job;
	private int level;
	private long gold;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		switch(job) {
		case "전사", "마법사", "궁수":
			this.job = job;
		}
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level <1) level = 1;
		this.level = level;
	}
	public long getGold() {
		return gold;
	}
	public void setGold(long gold) {
		if(gold < 0) return;
		this.gold = gold;
	}
	public long getExp() {
		return (long)this.level*this.level*this.level;
	}
	
	public String getTitle() {
		if(this.level < 10) return "초보자";
		if(this.level < 50) return "중수";
		else return "고수";
		
	}
	public Player(String id, String job, long gold) {
		this(id, job, 0, gold);
	}
	public Player(String id, String job, int level, long gold) {
		this.setId(id);
		this.setJob(job);
		this.setLevel(level);
		this.setGold(gold);
	}
	
	public void show() {
		System.out.println("<" + this.getId() + ">");
		System.out.println("직업 : " + this.getJob());
		System.out.println("레벨 : " + this.getLevel() + "(" +this.getTitle() + "), 다음 레벨로 가기 위한 필요경험치(exp) : " + this.getExp());
		System.out.println("골드 : " + this.getGold() + "골드");
	}
	

}

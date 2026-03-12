package oop.method9다시풀기;

public class Members {
	String name;
	String job;
	int age;
	float height;
	float weight;
	
	void setName(String name) {
		this.name = name;
	}
	void setJob(String job) {
		this.job = job;
	}
	void setAge(int age) {
		if(age <= 0)return;
	 this.age = age;
	}
	void setHeight(float height) {
		if(height < 0)return;
		this.height = height;
	}
	void setWeight(float weight) {
		if(weight < 0)return;
		this.weight = weight;
	}
	String getName() {
		return this.name;
	}
	String getJob() {
		return this.job;
	}
	int getAge() {
		return this.age;
	}
	float getHeight() {
		return this.height;
	}
	float getWeight() {
		return this.weight;
	}
	float getHeightMeter() {
		return this.height/100;
	}
	double getBmi() {
		return this.weight/(this.getHeightMeter()*this.getHeightMeter());
	}
	int getPrice() {
		if(this.age <= 7) return 0;
		else if(this.age >= 65) return 0;
		else if(this.age >= 20) return 1550;
		else if(this.age >= 19) return 900;
		else return 550;
	}
	void init(String name, String job, int age, float height, float weight) {
		this.setName(name);
		this.setJob(job);
		this.setAge(age);
		this.setHeight(height);
		this.setWeight(weight);
	}
	void show() {
		System.out.println("<" + this.getName() + ">");
		System.out.println("직업 : " + this.getJob());
		System.out.println("나이 : " + this.getAge() + "세");
		System.out.println("지하철 요금: " + this.getPrice() + "원");
		System.out.println("신장 : " + this.getHeight() + "cm");
		System.out.println("체중 : " + this.getWeight() + "kg");
		System.out.println("BMI 수치 : " + this.getBmi());
	}
	
}

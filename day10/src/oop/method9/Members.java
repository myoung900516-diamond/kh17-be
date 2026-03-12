package oop.method9;

public class Members {
	String name;
	String job;
	int age;
	int height;
	int weight;
	
	
	void setName(String name) {
		this.name = name;
	}
	void setJob(String job) {
		this.job = job;
	}
	void setAge(int age) {
		if(this.age <= 0)return;
		this.age = age;
	}
	void setHeight(int height) {
		if(this.height <= 0)return;
		this.height = height;
	}
	void setWeight(int weight) {
		if(this.weight <= 0)return;
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
	int getHeight() {
		return this.height;
	}
	int getWeight() {
		return this.weight;
	}
//	int price;
//	int getPrice() {
//		if(this.age >=65 ) {
//			price = 0;
//		}
//		else if(this.age>= 20 && this.age <= 64) {
//			price = 1550;
//		}
//		else if(this.age>= 14 && this.age <= 19) {
//			price = 900;
//		}
//		else if(this.age>= 8 && this.age<= 13) {
//			price = 550;
//		}
//		else {
//			price = 0;
//		}
//				return this.
//	}
//	
	double getBmi() {
		double height2 = this.height*this.height;
		return (double)this.weight/height2;
	}
	
	void init(String name, String job, int age, int height, int weight) {
		this.setName(name);
		this.setJob(job);
		this.setAge(age);
		this.setHeight(height);
		this.setWeight(weight);
	}

	void show() {
		System.out.println("BMI지수 : " + this.getBmi());
	}
}

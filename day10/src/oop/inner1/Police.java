package oop.inner1;

public class Police {
	//필드에 객체를 둘 수 있어요. 
	//경찰한테 총을 주게 하고 싶어요. 
	//객체를 조합할 수 있어요. 
	//객체도 필드로 쓸 수 있다. 
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private Gun gun;

	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}
	
	//경찰만 총을 가져야 하는데, 구조적으로 도둑도 총을 가질 수 있다. 
	

}

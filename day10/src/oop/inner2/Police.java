package oop.inner2;

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

	public void setGun(Gun gun) {
		this.gun = gun;
	}
	public Gun getGun() {
		return this.gun;
	}
	public Police() {
		Gun g = new Gun();
		this.setGun(g);
	}

	
	//경찰만 총을 가져야 하는데, 구조적으로 도둑도 총을 가질 수 있다. 
	
	//중첩클래스
	//-현재 클래스에 소속된 하위 클래스를 생성
	
	private class Gun{
		
	}
	
	

}

package oop.keyword4;
//회원(홈페이지)
public class Member {
	
	//필드가 final이면 생성자에서 반드시 설정해야함(안그러면 null로 잠기기 때문
	private final String id;
	private String pw;
	private String email;
	public Member(String id, String pw, String email) {
		//super();
		//세터메소드 쓰세요. 
		this.id = id;//딱 한번 (생성시)만 가능 
		this.setPw(pw);//계속 변경 가능
		this.setEmail(email);//계속 변경 가능 
//		this.pw = pw;
//		this.email = email;
	}
	//final항목은 변경이 불가하기 때문에 setter 메소드를 만들 수 없다. 
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	
	
	

}

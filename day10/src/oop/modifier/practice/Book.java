package oop.modifier.practice;

public class Book {
	private String title;
	private String genre;
	private int pages; //숫자 쓸 때 int 인지 long인지 한 번 고민하고 넘어가자
	private int price;
	private boolean rent; //String 으로 할 수 있음. 무엇을 쓰든 결과가 같게 나올 수있는 방법이 있어야함.
	//int를 써서 = 1-대여가능 2-대여중 3-예약중 4-대출불가 이라고 약속하자 (번호로 하면 데이터가 줄어듬)
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		switch(genre) {
		case "기술", "소설", "자기계발":
			this.genre = genre;
		}
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		if(pages < 50)return;
		this.pages = pages;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0)return;
		if(price % 500 != 0)return;
		this.price = price;
	}
	public boolean isRent() {
		return rent;
	}
	public void setRent(boolean rent) {
		this.rent = rent;
	}
	
	public int getTax() { //부가세 getVat()b,
		return this.price*(100+10)/100;
	}
	
	public Book(String title, String genre, int pages, int price) {
		this(title, genre, pages, price, true);
		
	}
	public Book(String title, String genre, int pages, int price, boolean rent) {
		this.setTitle(title);
		this.setGenre(genre);
		this.setPages(pages);
		this.setPrice(price);
		this.setRent(rent);
	}
	
	public void show() {
		System.out.println("<" + this.getTitle() + ">");
		System.out.println("장르 : " + this.getGenre());
		System.out.println("페이지 수 : " + this.getPages() + "쪽");
		System.out.println("대여료 : " + this.getTax() + "원(부가세포함)");
		if(this.isRent()) {
			System.out.println("대여가능");
		}
		else {
			System.out.println("대여중");
		}
		//System.out.println("대여여부 : " + this.isRent());
	}

}

package com.kh.spring10.dto;

import lombok.Data;

@Data
public class BookDto {
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private String bookPublicationDate;
	private int bookPrice;
	private String bookPublisher;
	private int bookPageCount;
	private String bookGenre;

	//표시용메소드
	public String getBookAuthorString() {
		if(bookAuthor == null) return "미상";
		return bookAuthor;
	}
	public String getBookPublicationDateString() {
		if(bookPublicationDate == null) return "알수없음";
		return bookPublicationDate;
	}
	public String getBookPublisherString() {
		if(bookPublisher == null) return "";
		return bookPublisher;
	}
}

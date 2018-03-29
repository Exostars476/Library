package com.formation.infotel.controller.dto;

import java.util.List;

import com.formation.infotel.entity.Book_copy;

public class BookShelfDto {
	
	private int bookId;
	private String bookShelfName;
	private String bookShelfDescription;
	private int number;
	
	List<Integer> book_copies;

	public int getBookId() {
		return bookId;
	}

	public String getBookShelfName() {
		return bookShelfName;
	}

	public void setBookShelfName(String bookShelfName) {
		this.bookShelfName = bookShelfName;
	}

	public String getBookShelfDescription() {
		return bookShelfDescription;
	}

	public void setBookShelfDescription(String bookShelfDescription) {
		this.bookShelfDescription = bookShelfDescription;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Integer> getBook_copies() {
		return book_copies;
	}

	public void setBook_copies(List<Integer> book_copies) {
		this.book_copies = book_copies;
	}

	public BookShelfDto(int bookId, String bookShelfName, String bookShelfDescription, int number,
			List<Integer> book_copies) {
		this.bookId = bookId;
		this.bookShelfName = bookShelfName;
		this.bookShelfDescription = bookShelfDescription;
		this.number = number;
		this.book_copies = book_copies;
	}

	
	
	
}

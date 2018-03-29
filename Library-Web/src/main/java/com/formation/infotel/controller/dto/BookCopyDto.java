package com.formation.infotel.controller.dto;

import java.util.List;

public class BookCopyDto {

    private String book_copyTitle;
    private int bookIsbn;
    private int bookShelfId;
    private List<Integer> bookBasketsId;

	public BookCopyDto() {
	}

	public BookCopyDto(String book_copyTitle, int isbn, int bookShelfId,
					   List<Integer> bookBasketsId) {
		this.book_copyTitle = book_copyTitle;
		this.bookIsbn = isbn;
		this.bookShelfId = bookShelfId;
		this.bookBasketsId = bookBasketsId;
	}

	public String getBook_copyTitle() {
		return book_copyTitle;
	}

	public void setBook_copyTitle(String book_copyTitle) {
		this.book_copyTitle = book_copyTitle;
	}

	public int getBookShelfId() {
		return bookShelfId;
	}

	public void setBookShelfId(int bookShelfId) {
		this.bookShelfId = bookShelfId;
	}

	public List<Integer> getBookBasketsId() {
		return bookBasketsId;
	}

	public void setBookBasketsId(List<Integer> bookBasketsId) {
		this.bookBasketsId = bookBasketsId;
	}

	public int getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(int bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
}

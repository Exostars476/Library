package com.formation.infotel.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BookShelf {

	@Id
	@GeneratedValue
	private int bookShelfId;
	private String bookShelfName;
	private String bookShelfDescription;
	private int number;
	
	@OneToMany(mappedBy = "bookShelf")
	private List<Book_copy> book_copies = new ArrayList<>();

	public BookShelf() {

	}

	public BookShelf(String bookShelfName, String bookShelfDescription) {
		this.bookShelfName = bookShelfName;
		this.bookShelfDescription = bookShelfDescription;
	}

	public BookShelf(String bookShelfName, String bookShelfDescription, List<Book_copy> book_copies) {
		this.bookShelfName = bookShelfName;
		this.bookShelfDescription = bookShelfDescription;
		this.book_copies = book_copies;
	}

	public String getBookShelfName() {
		return bookShelfName;
	}

	public void setBookShelfName(String bookShelfName) {
		this.bookShelfName = bookShelfName;
	}

	public List<Book_copy> getBook_copies() {
		return book_copies;
	}

	public void setBook_copies(List<Book_copy> book_copies) {
		this.book_copies = book_copies;
	}

	public String getBookShelfDescription() {
		return bookShelfDescription;
	}

	public void setBookShelfDescription(String bookShelfDescription) {
		this.bookShelfDescription = bookShelfDescription;
	}

	public String getbookShelfName() {
		return bookShelfName;
	}

	public void setbookShelfName(String bookShelfName) {
		this.bookShelfName = bookShelfName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBookShelfId() {
		return bookShelfId;
	}
}

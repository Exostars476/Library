package com.formation.infotel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private int authorId;
	private String authorLastName;
	private String firstName;

/*
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
	private List<Book> books = new ArrayList<>();
*/

	public Author() {

	}
	
	public Author(String authorLastName, String firstName) {
		this.authorLastName = authorLastName;
		this.firstName = firstName;
	}

	public int getAuthorId() {
		return authorId;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

/*
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
*/
}

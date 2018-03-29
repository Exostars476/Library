package com.formation.infotel.controller.dto;

import java.util.List;

import com.formation.infotel.entity.Book;

public class AuthorDto {

	private int id;
	private String authorLastName;
	private String firstName;
	//private List<Integer> booksId;

	public AuthorDto() {
	}

	public AuthorDto(String authorLastName, String firstName, int id) {
	//public AuthorDto(String authorLastName, String firstName, List<Integer> booksId, int id) {
		this.authorLastName = authorLastName;
		this.firstName = firstName;
		//this.booksId = booksId;
		this.id =id;
	}
	public int getId() {
		return id;
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
	public List<Integer> getBooksId() {
		return booksId;
	}

	public void setBooksId(List<Integer> books) {
		this.booksId = books;
	}
*/
}

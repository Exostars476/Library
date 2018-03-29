package com.formation.infotel.controller.dto;

import java.util.List;

public class CategoryDto {

	private int id;
	private String name;
	private String description;
	//private List<Integer> booksId;

	public CategoryDto() {
	}

	public CategoryDto(String name, String description, int id) {
	//public CategoryDto(String name, String description, List<Integer> booksId, int id) {

		this.name = name;
		this.description = description;
		//this.booksId = booksId;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

/*
	public List<Integer> getBooksId() {
		return booksId;
	}

	public void setBooksId(List<Integer> booksId) {
		this.booksId = booksId;
	}
*/

	@Override
	public String toString() {
		return "CategoryDto{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				//", booksId=" + booksId +
				'}';
	}
}

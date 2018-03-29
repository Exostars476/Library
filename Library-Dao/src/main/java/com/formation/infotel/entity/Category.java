package com.formation.infotel.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private int categoryId;
	@Column(unique = true)
	private String name;
	private String description;

	//@ManyToMany(fetch = FetchType.EAGER, mappedBy = "category")
	//private Set<Book> books = new HashSet<>();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Category category = (Category) o;
		return categoryId == category.categoryId;
	}

	@Override
	public int hashCode() {

		return Objects.hash(categoryId);
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Category() {

	}

	public int getCategoryId() {
		return categoryId;
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
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
*/
}

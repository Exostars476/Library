package com.formation.infotel.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Editor {
 
	@Id
	@GeneratedValue
	private int editorId;
	private String name;
	private String editorAddress;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "editor")
	private Set<Book> books;

	public Editor(String name, String editorAddress) {
		this.name = name;
		this.editorAddress = editorAddress;
	}
	
	public Editor() {

	}

	public int getEditorId() {
		return editorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEditorAddress() {
		return editorAddress;
	}

	public void setEditorAddress(String editorAddress) {
		this.editorAddress = editorAddress;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}

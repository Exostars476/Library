package com.formation.infotel.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
public class Book implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Isbn;
	private String bookTitle;
	private String bookDescription;
	private float bookPrice;
	private Date publicationDate;
	private boolean popularBook;
	private String imagePath;

	@ManyToOne
	private Category category;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "BOOK_AUTH",
			joinColumns = @JoinColumn(name = "BOOK_ID"),
			inverseJoinColumns = @JoinColumn(name = "AUTH_ID"))
	private Set<Author> authors = new HashSet<>();

	@ManyToOne
	private Editor editor;

	// TODO remove
	@OneToMany(mappedBy = "book")
	private List<Book_copy> book_copies;

	public Book() {

	}
	
	public Book(String bookTitle, String bookDescription, float bookPrice, Date publicationDate, boolean popularBook,
			String imagePath) {
		this.bookTitle = bookTitle;
		this.bookDescription = bookDescription;
		this.bookPrice = bookPrice;
		this.publicationDate = publicationDate;
		this.popularBook = popularBook;
		this.imagePath = imagePath;
	}



	public Book(String bookTitle, String bookDescription, float price, Date publicationDate,boolean popular) {
		this.bookTitle = bookTitle;
		this.bookDescription = bookDescription;
		this.bookPrice = price;
		this.publicationDate = publicationDate;
		this.popularBook = popular;
	}

	public int getIsbn() {
		return Isbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public boolean isPopularBook() {
		return popularBook;
	}

	public void setPopularBook(boolean popularBook) {
		this.popularBook = popularBook;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	/*public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}*/

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	public List<Book_copy> getBook_copies() {
		return book_copies;
	}

	public void setBook_copies(List<Book_copy> book_copies) {
		this.book_copies = book_copies;
	}
}

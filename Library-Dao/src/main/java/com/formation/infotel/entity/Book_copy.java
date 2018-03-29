package com.formation.infotel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Book_copy {

    @Id
    @GeneratedValue
    private int book_copyId;
    private String book_copyTitle;

    @ManyToOne
    private Book book;

    @ManyToOne
    private BookShelf bookShelf;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "book_copies")
    private Set<BookBasket> bookBaskets = new HashSet<>();

    public Book_copy() {
    }

    public Book_copy(String book_copyTitle, Book book, BookShelf bookShelf) {
        this.book_copyTitle = book_copyTitle;
        this.book = book;
        this.bookShelf = bookShelf;
    }

    public int getBook_copyId() {
        return book_copyId;
    }

    public Book_copy(String book_copyTitle) {
        this.book_copyTitle = book_copyTitle;
    }

    public String getBook_copyTitle() {
        return book_copyTitle;
    }

    public void setBook_copyTitle(String book_copyTitle) {
        this.book_copyTitle = book_copyTitle;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookShelf getBookShelf() {
        return bookShelf;
    }

    public void setBookShelf(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    public Set<BookBasket> getBookBaskets() {
        return bookBaskets;
    }

    public void setBookBaskets(Set<BookBasket> bookBaskets) {
        this.bookBaskets = bookBaskets;
    }
}

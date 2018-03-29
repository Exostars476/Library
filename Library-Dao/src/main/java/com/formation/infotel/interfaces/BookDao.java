package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Book;

import java.util.List;

public interface BookDao {
    
    Book getBookByDescrition(String description);

    Book getBookByName(String bookName);

    List<Book> getRecommandedBooks();

    List<Book> getBooksByCriteria(String bookTitle);

    List<Book> getAll();
}

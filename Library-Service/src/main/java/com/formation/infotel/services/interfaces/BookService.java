package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Book;
import java.util.List;

public interface BookService {
	
    void insertBook(Book book) throws Exception;

    void updateBook(Book book) throws Exception;

    void deleteBook(Book book) throws Exception;

    Book getBookById(int bookId) throws Exception;

    List<Book> getBooks() throws Exception;
    
	String getBookByDescription(String description) throws Exception;
	
	Book getBookByName(String bookName) throws Exception;

	List<Book> getRecommandedBooks() throws Exception;

	List<Book> getBooksByCriteria(String bookTitle);

	List<Book> getAll();
}

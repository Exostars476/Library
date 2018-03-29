package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Book;
import com.formation.infotel.entity.Book_copy;
import com.formation.infotel.exception.ErrorConstants;
import com.formation.infotel.interfaces.BookDao;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.services.interfaces.BookService;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service @Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private Dao dao;

    @Override
    public void insertBook(Book book)  throws Exception{
        dao.save(book);
    }

    @Override
    public void updateBook(Book book) throws Exception {
        dao.saveOrUpdate(book);
    }

    @Override
    public void deleteBook(Book book)  throws Exception{
        dao.delete(book);
    }

    @Override
    public Book getBookById(int bookId) throws Exception {
        return dao.get(Book.class, bookId);
    }

    @Override
    public List<Book> getBooks() throws Exception {
        return bookDao.getAll();
    }

	@Override
	public String getBookByDescription(String description)  throws Exception {
		return null;
	}

    @Override
    public Book getBookByName(String bookName)  throws Exception{
        Book book=bookDao.getBookByName(bookName);
        return book;
    }

    @Override
    public List<Book> getRecommandedBooks()  throws Exception{
    	
       	List<Book> books = null;
    	books = bookDao.getRecommandedBooks();
    	
    	if(books.isEmpty())
			throw new ServiceException(ErrorConstants.NO_RECOMMANDE_BOOK);
        return books;
    }

    @Override
    public List<Book> getBooksByCriteria(String bookTitle) {
        return bookDao.getBooksByCriteria(bookTitle);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}

package com.formation.infotel.services.impl;

import com.formation.infotel.entity.BookShelf;
import com.formation.infotel.entity.BookShelf;
import com.formation.infotel.exception.ErrorConstants;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.services.interfaces.BookShelfService;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookShelfServiceImpl implements BookShelfService {

    @Autowired
    private Dao dao;

    @Override
    public void insertBookShelf(BookShelf bookShelf)  throws Exception{
        dao.save(bookShelf);
    }

    @Override
    public void deleteBookShelf(BookShelf bookShelf) throws Exception {
        dao.delete(bookShelf);
    }

    @Override
    public void updateBookShelf(BookShelf bookShelf)  throws Exception{
        dao.saveOrUpdate(bookShelf);
    }

    @Override
    public BookShelf getBookShelf(int bookShelfId) throws Exception {
        return dao.get(BookShelf.class, bookShelfId);
    }

    @Override
    public List<BookShelf> getAllBookShelfs() throws Exception {
     
        
    	List<BookShelf> bookShelf = null;
    	bookShelf = dao.getAll(BookShelf.class);
    	
    	if(bookShelf.isEmpty())
			throw new ServiceException(ErrorConstants.BOOKSHELF_NOT_FOUND);

    	
        return bookShelf;
    }
}

package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Book_copy;
import com.formation.infotel.exception.ErrorConstants;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.services.interfaces.BookCopyService;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyServiceImpl implements BookCopyService {

    @Autowired
    private Dao dao;

    @Override
    public void insertBookCopy(Book_copy bookCopy)  throws Exception{
        dao.save(bookCopy);
    }

    @Override
    public void deleteBookCopy(Book_copy bookCopy)  throws Exception{
        dao.delete(bookCopy);
    }

    @Override
    public void updateBookCopy(Book_copy bookCopy) throws Exception {
        dao.saveOrUpdate(bookCopy);
    }

    @Override
    public Book_copy getBookCopy(int bookCopyId) throws Exception {
        return dao.get(Book_copy.class, bookCopyId);
    }

    @Override
    public List<Book_copy> getAll()  throws Exception{
    	List<Book_copy> cook_copy = null;
    	cook_copy = dao.getAll(Book_copy.class);
    	
    	if(cook_copy.isEmpty())
			throw new ServiceException(ErrorConstants.BOOK_COPY_NOT_FOUND);

    	
        return cook_copy;
    }
}

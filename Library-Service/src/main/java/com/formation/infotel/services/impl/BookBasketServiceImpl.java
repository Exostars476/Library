package com.formation.infotel.services.impl;

import com.formation.infotel.entity.BookBasket;
import com.formation.infotel.exception.ErrorConstants;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.services.interfaces.BookBasketService;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBasketServiceImpl implements BookBasketService {

    @Autowired
    private Dao dao;

    @Override
    public void insertBookBasket(BookBasket bookBasket) throws Exception {
        dao.save(bookBasket);
    }

    @Override
    public void deleteBookBasket(BookBasket bookBasket) throws Exception {
        dao.delete(bookBasket);
    }

    @Override
    public void updateBookBasket(BookBasket bookBasket) throws Exception {
        dao.saveOrUpdate(bookBasket);
    }

    @Override
    public BookBasket getBookBasket(int bookBasketId) throws Exception {
        return dao.get(BookBasket.class, bookBasketId);
    }

    @Override
    public List<BookBasket> getAllBookBaskets() throws Exception {
    	
    	List<BookBasket> bookBaskets = null;
    	bookBaskets = dao.getAll(BookBasket.class);
    	
    	if(bookBaskets.isEmpty())
			throw new ServiceException(ErrorConstants.BASKET_EMPTY);

        return bookBaskets;
    }
}

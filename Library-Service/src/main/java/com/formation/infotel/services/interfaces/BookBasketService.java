package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.BookBasket;

import java.util.List;

public interface BookBasketService {

    void insertBookBasket(BookBasket bookBasket) throws Exception;

    void deleteBookBasket(BookBasket bookBasket) throws Exception;

    void updateBookBasket(BookBasket bookBasket) throws Exception;

    BookBasket getBookBasket(int bookBasketId) throws Exception;

    List<BookBasket> getAllBookBaskets() throws Exception;
}

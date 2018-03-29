package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.BookShelf;

import java.util.List;

public interface BookShelfService {

    void insertBookShelf(BookShelf bookShelf) throws Exception;

    void deleteBookShelf(BookShelf bookShelf) throws Exception;

    void updateBookShelf(BookShelf bookShelf) throws Exception;

    BookShelf getBookShelf(int bookShelfId) throws Exception;

    List<BookShelf> getAllBookShelfs() throws Exception;
}

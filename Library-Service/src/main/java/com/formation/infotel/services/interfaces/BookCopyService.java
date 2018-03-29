package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Book_copy;

import java.util.List;

public interface BookCopyService {

    void insertBookCopy(Book_copy bookCopy) throws Exception;

    void deleteBookCopy(Book_copy bookCopy) throws Exception;

    void updateBookCopy(Book_copy bookCopy) throws Exception;

    Book_copy getBookCopy(int bookCopyId) throws Exception;

    List<Book_copy> getAll() throws Exception;
}

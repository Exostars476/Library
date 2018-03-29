package com.formation.infotel.interfaces;

import com.formation.infotel.entity.BookShelf;

public interface BookShelfDao {

    BookShelf getBookShelfByName(String bookShelfName);
}

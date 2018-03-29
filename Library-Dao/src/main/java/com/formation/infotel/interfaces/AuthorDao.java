package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Author;

import java.util.List;

public interface AuthorDao {

    Author getAuthorByName(String authorname);

    List<Author> getBookByAuthor(String authorId);
}

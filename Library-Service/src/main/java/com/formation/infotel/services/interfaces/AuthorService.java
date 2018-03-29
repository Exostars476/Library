package com.formation.infotel.services.interfaces;

import java.util.List;

import com.formation.infotel.entity.Author;
import com.formation.infotel.entity.Book;

public interface AuthorService {

	void insertAuthor(Author author)  throws Exception;

	void deleteAuthor(Author author)  throws Exception ;

	void updateAuthor(Author author) throws Exception ;

	Author getAuthor(int authorId) throws Exception ;

	List<Author> getAllAuthors()throws Exception;

	List<Book> getListBookByNameAuthor(String nameAuteur) throws Exception;

	/*Author getAuthorByName(String name) throws Exception;*/
}

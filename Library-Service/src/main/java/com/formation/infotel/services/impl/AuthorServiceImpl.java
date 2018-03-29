package com.formation.infotel.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.mapping.Array;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.entity.Author;
import com.formation.infotel.entity.Book;
import com.formation.infotel.exception.ErrorConstants;
import com.formation.infotel.interfaces.AuthorDao;
import com.formation.infotel.services.interfaces.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private Dao dao;

	@Override
	public void insertAuthor(Author author) throws Exception {
		dao.save(author);
	}

	@Override
	public void deleteAuthor(Author author) throws Exception {
		dao.delete(author);
	}

	@Override
	public void updateAuthor(Author author) throws Exception {
		dao.saveOrUpdate(author);
	}

	@Override
	public Author getAuthor(int authorId) throws Exception {

		Author author = null;
		author = dao.get(Author.class, authorId);
		if (author == null)
			throw new ServiceException(ErrorConstants.AUTHOR_NOT_FOUND);

		return author;
	}

	@Override
	public List<Author> getAllAuthors() throws Exception {
		List<Author> authors = dao.getAll(Author.class);
		
		if (authors.isEmpty())
			throw new ServiceException(ErrorConstants.AUTHOR_NOT_FOUND);
		
		return authors;
	}

	@Override
	public List<Book> getListBookByNameAuthor(String nameAuteur) throws Exception {

		List<Author> listAuthorByName = null;

		List<Book> listBookByNameAuteur = null;

		/*listAuthorByName = authorDao.getBookByAuthor(nameAuteur);
		if (listAuthorByName.isEmpty()) {
			throw new ServiceException(ErrorConstants.AUTHOR_NAME_EMPTY);
		}
		if (listAuthorByName.size() > 0) {

			for (Iterator<Author> iterator = listAuthorByName.iterator(); iterator.hasNext();) {
				Author author = (Author) iterator.next();
				listBookByNameAuteur = author.getBooks();

			}
		}

		listBookByNameAuteur.sort((p1, p2) -> p1.getBookTitle().compareTo(p2.getBookTitle()));
		System.out.println(listBookByNameAuteur);*/
		return listBookByNameAuteur;
	}

	/*
	 * @Override public Author getAuthorByName(String name) throws Exception {
	 * return authorDao.getAuthorByName(name); }
	 */
}

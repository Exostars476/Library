package com.formation.infotel.dao;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.infotel.entity.BookShelf;
import com.formation.infotel.interfaces.BookShelfDao;

@Repository
@Transactional
public class BookShelfDaoImpl implements BookShelfDao{

	
	@Autowired
	 private SessionFactory sessionFactory;

	@Override
	public BookShelf getBookShelfByName(String bookShelfName) {
	    Query<BookShelf> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM BookShelf where  bookShelfName = : bookShelfName"));
		query.setParameter(" bookShelfName",  bookShelfName);
		return (BookShelf) query.list().get(0);
	}
}

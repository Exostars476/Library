package com.formation.infotel.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.infotel.interfaces.Book_copyDao;

@Repository
@Transactional
public class Book_copyDaoImpl implements Book_copyDao {
	
    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public Book_copyDao getBook_copyByName(String book_copyName) {
		Query<Book_copyDao> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Book_copy where book_copyTitle = :book_copyName"));
		query.setParameter("book_copyname", book_copyName);
		return (Book_copyDao) query.list().get(0);
	}
}

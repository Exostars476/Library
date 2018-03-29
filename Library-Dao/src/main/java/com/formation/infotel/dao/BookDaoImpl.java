package com.formation.infotel.dao;

import com.formation.infotel.entity.Book;
import com.formation.infotel.interfaces.BookDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public Book getBookByDescrition(String description) {
		 Query<Book> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Book where bookDescription LIKE :description"));
	        query.setParameter("description", description);
	        return (Book) query.list().get(0);
	}

	@Override
	public Book getBookByName(String bookName) {
		Query<Book> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Book where bookTitle = :bookName"));
        query.setParameter("bookName", bookName);
        return (Book) query.list().get(0);
	}

    @Override
    public List<Book> getRecommandedBooks() {
        List<Book> books = sessionFactory.getCurrentSession().createQuery(String.format("FROM Book where popularBook = 1")).list();
        return books;
    }

	@Override
	public List<Book> getBooksByCriteria(String bookTitle) {
	    Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Book.class).add(Restrictions.like("bookTitle", "%" + bookTitle + "%"));



		System.out.println("BookServiceImpl.getBooksByCriteria:bookTitle : " + bookTitle);
		List<Book> books = crit.list();

		return books;
	}

	public List<Book> getAll() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria crit = session.createCriteria(Book.class).addOrder(Order.asc("bookTitle"));

		String jpql = "select distinct b from Book b order by b.bookTitle";
		Query<Book> query = session.createQuery(jpql, Book.class);

		return query.getResultList();

		//Set<Book> result = new HashSet<>(crit.list());

		//return new ArrayList(result);
	}
}

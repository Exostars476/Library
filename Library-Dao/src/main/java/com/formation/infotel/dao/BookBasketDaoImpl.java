package com.formation.infotel.dao;

import java.util.Date;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.formation.infotel.entity.BookBasket;
import com.formation.infotel.interfaces.BookBasketDao;

@Repository
@Transactional
public class BookBasketDaoImpl implements BookBasketDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public BookBasket getBasketDelivary(Date deliveryDate) {
	    Query<BookBasket> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM BookBasket where deliveryDate = :deliveryDate"));
	    query.setParameter("deliveryDate", deliveryDate);
	    return (BookBasket) query.list().get(0);
	}
}

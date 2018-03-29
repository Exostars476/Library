package com.formation.infotel.dao;

import com.formation.infotel.entity.Author;
import com.formation.infotel.interfaces.AuthorDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Author getAuthorByName(String authorname) {
        Query<Author> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Author where authorLastName = :authorname"));
        query.setParameter("authorname", authorname);
        return (Author) query.list().get(0);
    }

	@Override
	public List<Author> getBookByAuthor(String authorLastName) {
		Query<Author> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Author where authorLastName = :authorLastName"));
        query.setParameter("authorLastName", authorLastName);
        return  query.list();
	}
}

package com.formation.infotel.dao;

import com.formation.infotel.entity.Category;
import com.formation.infotel.interfaces.CategoryDao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getAllBookByCategory(String categoryname) {
        Query<Category> query = sessionFactory.getCurrentSession().createQuery(String.format("SELECT Category.books as books FROM Category as cat" +
                " where cat.name = :categoryname"));
        query.setParameter("categoryname", categoryname);
        return  query.list();
    }

	@Override
	public Category getCategoriesPeriodique(String categoryName) {
		/*String categoryname = "Periodique";
		 Query<Category> query = sessionFactory.getCurrentSession().createQuery("FROM Category where name = :categoryname");
	        query.setParameter("categoryname", categoryname);
	        return (Category) query.list().get(0);*/
		return (Category) sessionFactory.getCurrentSession().get(Category.class, categoryName);
	}

    @Override
    public Category getCategoryByName(String name) {
        Query<Category> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Category where name = :categoryname"));
        query.setParameter("categoryname", name);
        return (Category) query.list().get(0);
    }

    @Override
    public List<Category> getAll() {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(Category.class);
        return crit.list();
    }
}

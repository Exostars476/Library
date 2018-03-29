package com.formation.infotel.dao;

import com.formation.infotel.interfaces.Dao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class DaoImpl implements Dao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public <T> T save(final T o){
        return (T) sessionFactory.getCurrentSession().save(o);
    }

    @Override
    public void delete(final Object object){
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public <T> T get(final Class<T> type, final int id){
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public <T> T merge(final T o)   {
        return (T) sessionFactory.getCurrentSession().merge(o);
    }

    @Override
    public <T> void saveOrUpdate(final T o){
        sessionFactory.getCurrentSession().saveOrUpdate(o);
    }

    @Override
    public <T> List getAll(final Class<T> type) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        //crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        Set<?> result = new HashSet<>(crit.list());

        return new ArrayList(result);
    }
}

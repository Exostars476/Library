package com.formation.infotel.dao;

import com.formation.infotel.entity.Editor;
import com.formation.infotel.interfaces.EditorDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EditorDaoImpl implements EditorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Editor getEditorByName(String editorname) {
        Query<Editor> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Editor where name = :editorname"));
        query.setParameter("editorname", editorname);
        return (Editor) query.list().get(0);
    }
}

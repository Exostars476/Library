package com.formation.infotel.dao;

import com.formation.infotel.entity.MemLibId;
import com.formation.infotel.entity.Registration;
import com.formation.infotel.interfaces.RegistrationDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RegistrationDaoImpl implements RegistrationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Registration getById(MemLibId id) {
        Registration registration = new Registration();
        List<Registration> registrations = sessionFactory.getCurrentSession().createQuery(String.format("From Registration as r Where r.id= :id")).setParameter("id", id).list();
        if(registrations.size() == 1){
            registration = registrations.get(0);
        }
        return registration;
    }
}

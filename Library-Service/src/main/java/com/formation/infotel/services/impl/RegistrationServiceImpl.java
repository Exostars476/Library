package com.formation.infotel.services.impl;

import com.formation.infotel.entity.MemLibId;
import com.formation.infotel.entity.Registration;
import com.formation.infotel.exception.ErrorConstants;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.interfaces.RegistrationDao;
import com.formation.infotel.services.interfaces.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ServiceConfigurationError;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private Dao dao;
    @Autowired
    private RegistrationDao registrationDao;

    @Override
    public void insertRegistration(Registration registration)  throws Exception{
        dao.save(registration);
    }

    @Override
    public void deleteRegistration(Registration registration)  throws Exception{
        dao.delete(registration);
    }

    @Override
    public void updateRegistration(Registration registration)  throws Exception{
        dao.saveOrUpdate(registration);
    }

    @Override
    public Registration getRegistration(MemLibId registrationId)  throws Exception{
        return registrationDao.getById(registrationId);
    }

    @Override
    public List<Registration> getAllRegistrations() throws Exception {
    	
    	List<Registration> registration = null;
    	registration = dao.getAll(Registration.class);
    	
    	if (registration.isEmpty())
    		throw new ServiceConfigurationError(ErrorConstants.REGISTRATION_LIST_EMPTY);
    	
        return registration;
    }
}

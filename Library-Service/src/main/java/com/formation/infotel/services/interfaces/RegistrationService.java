package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.MemLibId;
import com.formation.infotel.entity.Registration;

import java.util.List;

public interface RegistrationService {

    void insertRegistration(Registration registration) throws Exception;

    void deleteRegistration(Registration registration) throws Exception;

    void updateRegistration(Registration registration) throws Exception;

    Registration getRegistration(MemLibId registrationId) throws Exception;

    List<Registration> getAllRegistrations() throws Exception;
}

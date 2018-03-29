package com.formation.infotel.interfaces;

import com.formation.infotel.entity.MemLibId;
import com.formation.infotel.entity.Registration;

public interface RegistrationDao {

    Registration getById(MemLibId id);
}

package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Member;

public interface LoginService {

	Member Login(String email,String password) throws Exception;
	
}

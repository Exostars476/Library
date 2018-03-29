package com.formation.infotel.services.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.infotel.entity.Member;
import com.formation.infotel.exception.ErrorConstants;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.interfaces.MemberDao;
import com.formation.infotel.services.interfaces.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private Dao dao;
	@Autowired
	private MemberDao memberDao;

	@Override
	public Member Login(String email, String password) throws Exception {
		if (!memberDao.userExist(email, password))
			throw new ServiceException(ErrorConstants.ACCCOUNT_NOT_EXISTING);
		else
			return memberDao.getMemberByEmail(email);

	}

}

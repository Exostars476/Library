package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Member;
import com.formation.infotel.exception.ErrorConstants;
import com.formation.infotel.exception.ServiceException;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.interfaces.MemberDao;
import com.formation.infotel.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private Dao dao;

    @Override
    public void insertMember(Member member)  throws Exception{
        dao.save(member);
    }

    @Override
    public void deleteMember(Member member)  throws Exception{
        dao.delete(member);
    }

    @Override
    public void updateMember(Member member)  throws Exception{
        dao.saveOrUpdate(member);
    }

    @Override
    public Member getMember(int memberId)  throws Exception{
        return dao.get(Member.class, memberId);
    }

    @Override
    public List<Member> getAllMembers()  throws Exception{
    	List<Member> member = null;
    	member = dao.getAll(Member.class);
    	if (member.isEmpty())
    		throw new ServiceException(ErrorConstants.MEMBER_LIST_EMPTY);
        return member;
    }

    @Override
    public Member getMemberByEmail(String email) throws Exception {
    	Member member = null;
    	member = memberDao.getMemberByEmail(email);
    	
    	if(member == null)
    		throw new ServiceException(ErrorConstants.EMAIL_NOT_FOUND);
    	
        return member;
    }

    @Override
    public boolean userExist(String login, String password)  throws Exception{
    	
        return memberDao.userExist(login, password);
    }
}

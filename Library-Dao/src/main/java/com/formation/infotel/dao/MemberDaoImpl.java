package com.formation.infotel.dao;

import com.formation.infotel.entity.Member;
import com.formation.infotel.interfaces.MemberDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Member getMemberByEmail(String email) {
        Member member = new Member();
        List<Member> members = sessionFactory.getCurrentSession().createQuery(String.format("From Member as m Where m.email= :email")).setParameter("email", email).list();
        if(members.size() == 1){
            member = members.get(0);
        }
        return member;
    }

    @Override
    public boolean userExist(String login, String password){
        boolean success = false;
        List<Member> members = sessionFactory.getCurrentSession().createQuery(String.format("FROM Member WHERE email= :login AND password= :password "))
                .setParameter("login", login)
                .setParameter("password", password)
                .list();
        System.out.println(members);
        if(members.size() == 1){
            success = true;
        }
        return success;
    }
}
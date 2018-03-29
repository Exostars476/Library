package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Member;

import java.util.List;

public interface MemberService {

    void insertMember(Member member) throws Exception;

    void deleteMember(Member member) throws Exception;

    void updateMember(Member member) throws Exception;

    Member getMember(int memberId) throws Exception;

    List<Member> getAllMembers() throws Exception;

    boolean userExist(String login, String password) throws Exception;

    Member getMemberByEmail(String email) throws Exception;
}

package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Member;

public interface MemberDao {

    boolean userExist(String login, String password);

    Member getMemberByEmail(String email);
}

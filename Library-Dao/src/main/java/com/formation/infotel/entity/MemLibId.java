package com.formation.infotel.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MemLibId implements Serializable{

    @Column(name = "memberId")
    private int memberId;

    @Column(name = "libraryCode")
    private int libraryCode;

    public MemLibId() {
    }

    public MemLibId(int memberId, int libraryCode) {
        this.memberId = memberId;
        this.libraryCode = libraryCode;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getLibraryCode() {
        return libraryCode;
    }

    public void setLibraryCode(int libraryCode) {
        this.libraryCode = libraryCode;
    }
}

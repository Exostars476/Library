package com.formation.infotel.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Registration")
public class Registration {

	@Column(name = "ID")
	@EmbeddedId
	private MemLibId id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId("memberId")
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("libraryCode")
	private Library library;

	@Column(name = "registration_date")
	private Date registrationDate;

	public Registration() {
	}

	public Registration(Member member, Library library, Date registrationDate) {
		this.id = new MemLibId(member.getMemberId(), library.getLibraryCode());
		this.member = member;
		this.library = library;
		this.registrationDate = registrationDate;
	}

	public MemLibId getId() {
		return id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
}

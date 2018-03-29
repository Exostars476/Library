package com.formation.infotel.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Library {

	@Id
	@GeneratedValue
	private int libraryCode;
	private String libraryName;
	private String libraryAddress;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "library")
	private List<Registration> registrations;

	public Library(String libraryName, String libraryAddress, List<Registration> registrations) {
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
		this.registrations = registrations;
	}

	public Library(String libraryName, String libraryAddress) {
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
	}

	public Library() {

	}

	public int getLibraryCode() {
		return libraryCode;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryAddress() {
		return libraryAddress;
	}

	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}

	public void setLibraryCode(int libraryCode) {
		this.libraryCode = libraryCode;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}
}

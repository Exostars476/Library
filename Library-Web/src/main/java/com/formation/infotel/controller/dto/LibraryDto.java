package com.formation.infotel.controller.dto;

import com.formation.infotel.entity.MemLibId;

import java.util.List;

public class LibraryDto {

	private String libraryName;
	private String libraryAddress;
	private List<MemLibId> registrationsId;

	public LibraryDto() {
	}

	public LibraryDto(String libraryName, String libraryAddress, List<MemLibId> registrationsId) {
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
		this.registrationsId = registrationsId;
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

	public List<MemLibId> getRegistrationsId() {
		return registrationsId;
	}

	public void setRegistrationsId(List<MemLibId> registrationsId) {
		this.registrationsId = registrationsId;
	}
}

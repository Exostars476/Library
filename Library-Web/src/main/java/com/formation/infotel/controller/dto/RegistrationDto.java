package com.formation.infotel.controller.dto;

import java.util.Date;



import com.formation.infotel.entity.Library;
import com.formation.infotel.entity.MemLibId;
import com.formation.infotel.entity.Member;

public class RegistrationDto {


	private int memLibId;


	private int memberId;


	private  int libraryCode;

	private Date registrationDate;

	public int getMemLibId() {
		return memLibId;
	}

	public int getMemberId() {
		return memberId;
	}

	public int getLibraryCode() {
		return libraryCode;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public RegistrationDto(int memLibId, int memberId, int libraryCode, Date registrationDate) {
		this.memLibId = memLibId;
		this.memberId = memberId;
		this.libraryCode = libraryCode;
		this.registrationDate = registrationDate;
	}
	

}

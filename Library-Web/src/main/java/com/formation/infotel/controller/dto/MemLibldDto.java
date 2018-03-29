package com.formation.infotel.controller.dto;



public class MemLibldDto {
	

    private int memberId;


    private int libraryCode;


	public int getMemberId() {
		return memberId;
	}


	public int getLibraryCode() {
		return libraryCode;
	}


	public MemLibldDto(int memberId, int libraryCode) {
		this.memberId = memberId;
		this.libraryCode = libraryCode;
	}


}

package com.formation.infotel.controller.dto;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.formation.infotel.entity.BookBasket;

public class BorrowDto {
	
	private  int borowId;  
	private Date borowDate;
	private Date returnDate;


	private  int boookBasketId;


	public int getBorowId() {
		return borowId;
	}

	public Date getBorowDate() {
		return borowDate;
	}


	public void setBorowDate(Date borowDate) {
		this.borowDate = borowDate;
	}


	public Date getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


	public int getBoookBasketId() {
		return boookBasketId;
	}



	
	
}

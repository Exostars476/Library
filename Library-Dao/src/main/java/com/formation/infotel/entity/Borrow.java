package com.formation.infotel.entity;

import java.lang.reflect.Member;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Borrow {
	
	@Id
	@GeneratedValue
	private  int borowId;  
	private Date borowDate;
	private Date returnDate;

	@OneToOne
	@JoinColumn(name = "bookBasket_id")
	private BookBasket bookBasket;
	
	public Borrow() {

	}

	public Borrow(Date borowDate, Date returnDate) {
		this.borowDate = borowDate;
		this.returnDate = returnDate;
	}

	public Borrow(Date borowDate, Date returnDate, BookBasket bookBasket, Member member) {
		this.borowDate = borowDate;
		this.returnDate = returnDate;
		this.bookBasket = bookBasket;
	}

	public BookBasket getBookBasket() {
		return bookBasket;
	}

	public void setBookBasket(BookBasket bookBasket) {
		this.bookBasket = bookBasket;
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

	public int getBorowId() {
		return borowId;
	}
}

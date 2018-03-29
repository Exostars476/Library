package com.formation.infotel.controller.dto;

import java.util.Date;
import java.util.List;

import com.formation.infotel.entity.Book_copy;

public class BookBasketDto {

	private Date creationDate;
	private Date deliveryDate;
	private int memberId;
	private List<Integer> book_copiesId;

	public BookBasketDto() {
	}

	public BookBasketDto(Date creationDate, Date deliveryDate, int memberId, List<Integer> book_copiesId) {
		this.creationDate = creationDate;
		this.deliveryDate = deliveryDate;
		this.memberId = memberId;
		this.book_copiesId = book_copiesId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public List<Integer> getBook_copiesId() {
		return book_copiesId;
	}

	public void setBook_copiesId(List<Integer> book_copiesId) {
		this.book_copiesId = book_copiesId;
	}
}

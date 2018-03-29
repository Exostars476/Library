package com.formation.infotel.entity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="Book_Basket")
public class BookBasket {

	@Id
	@GeneratedValue
	private int boookBasketId;
	private Date creationDate;
	private Date deliveryDate;

	@OneToOne
	@JoinColumn(name = "Member_id")
	private Member member;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "BASKET_COPY",
		joinColumns = @JoinColumn(name = "BASKET_ID"),
		inverseJoinColumns = @JoinColumn(name = "COPY_ID"))
	private Set<Book_copy> book_copies = new HashSet<>();

	public BookBasket(Date creationDate, Date deliveryDate, Member member,
			Set<Book_copy> book_copies) {
		this.creationDate = creationDate;
		this.deliveryDate = deliveryDate;
		this.member = member;
		this.book_copies = book_copies;
	}

	public BookBasket(Date creationDate, Date deliveryDate) {
		this.creationDate = creationDate;
		this.deliveryDate = deliveryDate;
	}

	public BookBasket() {
	
	}

	public Member getMember() {
			return member;
		}

	public void setMember(Member member) {
		this.member = member;
	}

	public Set<Book_copy> getBook_copies() {
		return book_copies;
	}

	public void setBook_copies(Set<Book_copy> book_copies) {
		this.book_copies = book_copies;
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

	public int getBoookBasketId() {
			return boookBasketId;
		}
}

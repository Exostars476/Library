package com.formation.infotel.interfaces;

import java.util.Date;

import com.formation.infotel.entity.BookBasket;

public interface BookBasketDao {
	
	BookBasket getBasketDelivary(Date deliveryDate);
}

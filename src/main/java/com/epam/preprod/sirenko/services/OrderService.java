package com.epam.preprod.sirenko.services;

import com.epam.preprod.sirenko.dao.OrderDAO;
import com.epam.preprod.sirenko.entity.Product;

import java.math.BigDecimal;
import java.util.Map;

public class OrderService {
	OrderDAO orderDAO;
	
	public OrderService(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	public void makeOrder(Map<Product, Integer> cart) {
		orderDAO.makeOrder(cart);
	}
	
	public BigDecimal countAmount() {
		return orderDAO.countAmount();
	}
	
}

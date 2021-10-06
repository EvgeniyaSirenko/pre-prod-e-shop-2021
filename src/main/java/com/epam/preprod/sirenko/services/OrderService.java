package com.epam.preprod.sirenko.services;

import com.epam.preprod.sirenko.dao.OrderDAO;
import com.epam.preprod.sirenko.entity.Product;

import java.sql.Timestamp;
import java.util.Map;

public class OrderService {
	private OrderDAO orderDAO;
	
	public OrderService(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	public void makeOrder(Timestamp creationTime, Map<Product, Integer> cart) {
		orderDAO.makeOrder(creationTime, cart);
	}
}

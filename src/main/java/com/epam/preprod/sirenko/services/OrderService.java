package com.epam.preprod.sirenko.services;

import com.epam.preprod.sirenko.dao.OrderDAO;
import com.epam.preprod.sirenko.entity.Product;

import java.sql.Timestamp;
import java.util.Map;

/**
 * This class is for work with OrderDAO
 */
public class OrderService {
	private OrderDAO orderDAO;
	
	public OrderService(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	public void makeOrder(Timestamp creationTime, Map<Product, Integer> cart) {
		orderDAO.makeOrder(creationTime, cart);
	}
	
	public Map<Timestamp, Map<Product, Integer>> getOrdersListOfCurrentPeriod(Timestamp dateFrom, Timestamp dateTo) {
		return orderDAO.getOrdersListOfCurrentPeriod(dateFrom, dateTo);
	}
	
	public Map<Product, Integer> getOrdersClosestToDate(Timestamp date) {
		return orderDAO.getOrdersClosestToDate(date);
	}
}

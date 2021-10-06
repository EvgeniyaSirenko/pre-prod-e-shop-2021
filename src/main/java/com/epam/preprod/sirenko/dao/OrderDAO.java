package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.entity.Product;

import java.sql.Timestamp;
import java.util.Map;
import java.util.TreeMap;

public class OrderDAO {
	 Map<Timestamp, Map<Product, Integer>> orders = new TreeMap<>();
	
	public void makeOrder(Timestamp creationTime, Map<Product, Integer> cart) {
		orders.put(creationTime, cart);
	}
	
}

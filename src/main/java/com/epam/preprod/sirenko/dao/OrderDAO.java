package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.entity.Product;

import java.sql.Timestamp;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class OrderDAO {
	NavigableMap<Timestamp, Map<Product, Integer>> orders = new TreeMap<>();
	
	public void makeOrder(Timestamp creationTime, Map<Product, Integer> cart) {
		orders.put(creationTime, cart);
	}
	
	public Map<Timestamp, Map<Product, Integer>> getOrdersListOfCurrentPeriod(Timestamp dateFrom, Timestamp dateTo) {
		return orders.subMap(dateFrom, true, dateTo, true);
	}
	
	public Map<Product, Integer> getOrdersClosestToDate(Timestamp date) {
		if (orders.ceilingKey(date) == null) {
			return orders.get(orders.floorKey(date));
		}
		return orders.get(orders.ceilingKey(date));
	}
}

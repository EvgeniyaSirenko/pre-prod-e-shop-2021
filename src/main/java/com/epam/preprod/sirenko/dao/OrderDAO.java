package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.entity.Product;

import java.sql.Timestamp;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * This class holds treeMap of orders
 */
public class OrderDAO {
	private NavigableMap<Timestamp, Map<Product, Integer>> orders = new TreeMap<>();
	
	public void makeOrder(Timestamp creationTime, Map<Product, Integer> cart) {
		orders.put(creationTime, cart);
	}
	
	public Map<Timestamp, Map<Product, Integer>> getOrdersListOfCurrentPeriod(Timestamp dateFrom, Timestamp dateTo) {
		return orders.subMap(dateFrom, true, dateTo, true);
	}
	
	public Map<Product, Integer> getOrdersClosestToDate(Timestamp date) {
		Timestamp before = orders.floorKey(date);
		Timestamp after = orders.ceilingKey(date);
		if (after == null) {
			return orders.get(before);
		}
		if (before == null) {
			return orders.get(after);
		}
		long diffDateToBefore = date.getTime() - before.getTime();
		long diffAfterToDate = after.getTime() - date.getTime();
		if (diffDateToBefore < diffAfterToDate) {
			return orders.get(orders.floorKey(date));
		}
		return orders.get(orders.ceilingKey(date));
	}
}

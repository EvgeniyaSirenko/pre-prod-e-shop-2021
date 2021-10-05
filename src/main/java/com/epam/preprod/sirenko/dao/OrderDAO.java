package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.entity.Product;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class OrderDAO {
	Map<Product, Integer> order = new LinkedHashMap<>();
	//TODO
	// Map<Timestamp, Product> order = new TreeMap<>();
	
	public void makeOrder(Map<Product, Integer> cart) {
		order.putAll(cart);
	}
	
	public BigDecimal getOrderTotalPrice() {
		BigDecimal sum = BigDecimal.valueOf(0);
		for (Map.Entry<Product, Integer> set : order.entrySet()) {
			if (set.getValue() > 1) {
				sum = set.getKey().getPrice().multiply(BigDecimal.valueOf(set.getValue())).add(sum);
			} else {
				sum = set.getKey().getPrice().add(sum);
			}
		}
		return sum;
	}
}

package com.epam.preprod.sirenko.entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<Product, Integer> usersCart = new LinkedHashMap<>();
	
	public Cart() {
	}
	
	public Cart(Map<Product, Integer> usersCart) {
		this.usersCart = usersCart;
	}
	
}
package com.epam.preprod.sirenko.entity;

import java.util.Objects;

/**
 * Products entity.
 *
 * @author E.Sirenko
**/
public abstract class Products {
	private String name;
	private int price;
	
	public Products() {
	}
	
	public Products(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Products{" +
				"name='" + name + '\'' +
				", price=" + price +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Products)) return false;
		Products products = (Products) o;
		return getPrice() == products.getPrice() && getName().equals(products.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), getPrice());
	}
}

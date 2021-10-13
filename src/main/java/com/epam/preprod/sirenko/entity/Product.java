package com.epam.preprod.sirenko.entity;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Products entity.
 *
 * @author E.Sirenko
 *
**/
public abstract class Product{
	private String name;
	private BigDecimal price;
	
	protected Product() {
	}
	
	protected Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Products{" +
				"name='" + name +
				", price=" + price +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product)) return false;
		Product product = (Product) o;
		return getName().equals(product.getName()) && getPrice().equals(product.getPrice());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), getPrice());
	}
}

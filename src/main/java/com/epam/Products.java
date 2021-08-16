package com.epam;

import java.util.Objects;

public abstract class Products {
	
	int id;
	String name;
	int price;
	
	public Products() {
	}
	
	public Products(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Products)) return false;
		Products products = (Products) o;
		return getId() == products.getId() && getName().equals(products.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName());
	}
}

package com.epam;

public class ProductsType extends Brand {
	int id;
	String name;
	
	public ProductsType() {
	}
	
	public ProductsType(int id, String name, int price, int id1, String name1, int id2, String name2) {
		super(id, name, price, id1, name1);
		this.id = id2;
		this.name = name2;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ProductsType{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}

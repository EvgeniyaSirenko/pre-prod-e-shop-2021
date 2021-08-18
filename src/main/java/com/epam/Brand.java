package com.epam;

public class Brand extends Products {
	int id;
	String name;
	
	public Brand() {
	}
	
	public Brand(int id, String name, int price, int id1, String name1) {
		super(id, name, price);
		this.id = id1;
		this.name = name1;
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
		return "Brand{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
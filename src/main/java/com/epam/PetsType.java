package com.epam;

public class PetsType extends ProductsType {
	
	int id;
	String name;
	
	public PetsType() {
	}
	
	public PetsType(int id, String name, int price, int id1, String name1, int id2, String name2, int id3, String name3) {
		super(id, name, price, id1, name1, id2, name2);
		this.id = id3;
		this.name = name3;
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
		return "PetsType{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}

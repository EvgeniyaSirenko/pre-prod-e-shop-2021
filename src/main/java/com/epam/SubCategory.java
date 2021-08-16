package com.epam;

public class SubCategory extends Category {
	
	int id;
	String name;
	String categoryName;
	
	public SubCategory() {
	}
	
	public SubCategory(int id, String name, int id1, String name1, String categoryName) {
		super(id, name);
		this.id = id1;
		this.name = name1;
		this.categoryName = categoryName;
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
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return "SubCategory{" +
				"id=" + id +
				", name='" + name + '\'' +
				", categoryName='" + categoryName + '\'' +
				'}';
	}
}

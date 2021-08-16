package com.epam;

public class Brand extends SubCategory {
	int id;
	String name;
	String subCategoryName;
	
	public Brand() {
	}
	
	public Brand(int id, String name, int id1, String name1, String categoryName, int id2, String name2, String subCategoryName) {
		super(id, name, id1, name1, categoryName);
		this.id = id2;
		this.name = name2;
		this.subCategoryName = subCategoryName;
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
	
	public String getSubCategoryName() {
		return subCategoryName;
	}
	
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	
	@Override
	public String toString() {
		return "Brand{" +
				"id=" + id +
				", name='" + name + '\'' +
				", subCategoryName='" + subCategoryName + '\'' +
				'}';
	}
}

package com.epam;

public class Product extends Brand {
	int id;
	String name;
	int price;
	String brandName;
	
	public Product() {
	}
	
	public Product(int id, String name, int id1, String name1, String categoryName, int id2, String name2, String subCategoryName, int id3, String name3, int price, String brandName) {
		super(id, name, id1, name1, categoryName, id2, name2, subCategoryName);
		this.id = id3;
		this.name = name3;
		this.price = price;
		this.brandName = brandName;
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
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				", brandName='" + brandName + '\'' +
				'}';
	}
}

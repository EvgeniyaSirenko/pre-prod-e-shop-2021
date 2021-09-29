package com.epam.preprod.sirenko.DAO;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductsInDBDAO {
	Food food;
	Clothing clothing;
	
	public List<Product> productsSetup() {
		food = new Food("food", BigDecimal.valueOf(10), 20);
		clothing = new Clothing("clothing", BigDecimal.valueOf(20), Size.S, Season.WINTER);
		List<Product> productList = new ArrayList<>();
		productList.add(food);
		productList.add(clothing);
		
		return productList;
	}
}

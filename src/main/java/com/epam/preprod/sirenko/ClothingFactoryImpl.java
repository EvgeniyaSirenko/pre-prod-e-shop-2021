package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;

public class ClothingFactoryImpl implements CreateProductFactory {
	
	@Override
	public Product createProduct(Strategy strategy) {
		Clothing clothing = new Clothing();
		clothing.setSize((Size) strategy.getEnum());
		clothing.setSeason((Season) strategy.getEnum());
		clothing.setName(strategy.getString());
		clothing.setPrice(strategy.getBigDecimal());
		return clothing;
	}
}

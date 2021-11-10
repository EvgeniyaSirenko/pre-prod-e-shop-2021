package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.Product;

public interface CreateProductFactory {
	Product createProduct(Strategy strategy);
}

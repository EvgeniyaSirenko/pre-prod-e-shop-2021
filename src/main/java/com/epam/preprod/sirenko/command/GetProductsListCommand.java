package com.epam.preprod.sirenko.command;

import com.epam.preprod.sirenko.DAO.ProductsInDBDAO;
import com.epam.preprod.sirenko.entity.Product;

import java.util.List;

public class GetProductsListCommand extends Command{
	
	@Override
	public List<Product> execute() {
		ProductsInDBDAO productsInDBDAO = new ProductsInDBDAO();
		return productsInDBDAO.productsSetup();
	}
}

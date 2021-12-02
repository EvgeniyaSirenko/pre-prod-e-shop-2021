package com.epam.preprod.sirenko.services.impl;

import com.epam.preprod.sirenko.dao.ProductDAO;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.services.SerializationService;

import java.io.*;
import java.util.ArrayList;

public class SerializationServiceImpl implements SerializationService, Serializable {
	private static final String FILE_NAME = "products.dat";
	private ProductDAO productDAO;
	
	public SerializationServiceImpl(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public void serializeProductsListToFile() {
		ArrayList<Product> allProducts = (ArrayList<Product>) productDAO.getAllProductsList();
		if (!allProducts.isEmpty()) {
			try (
					FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
			) {
				objectOutputStream.writeObject(allProducts);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void serializeProductsListFromFile() {
		ArrayList<Product> newProducts;
		File file = new File(FILE_NAME);
		if (!file.exists()) {
			return;
		}
		try (
				FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
		) {
			newProducts = (ArrayList<Product>) objectInputStream.readObject();
			productDAO.setProductsList(newProducts);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

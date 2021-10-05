package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.ConsoleReader;
import com.epam.preprod.sirenko.PrintToConsole;
import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.services.CartService;
import com.epam.preprod.sirenko.services.ProductService;

import java.io.IOException;
import java.util.List;

public class AddProductToCartCommand implements Command {
	private CartService cartService;
	private ProductService productService;
	
	public AddProductToCartCommand(CartService cartService, ProductService productService) {
		this.cartService = cartService;
		this.productService = productService;
	}
	
	@Override
	public void execute() {
		List<Product> products = productService.getAllProducts();
			for (int i = 1; i <= products.size(); i++) {
					System.out.println(i + " - " + products.get(i-1));
			}
		PrintToConsole.printString("Print product number and press Enter to add product to cart");
		try {
			String productNumber = ConsoleReader.readFromConsole();
			if (Integer.parseInt(productNumber) > products.size() || Integer.parseInt(productNumber) < 1) {
				PrintToConsole.printString("No such product number");
				return;
			}
			Product productToAdd = productService.getAllProducts().get(Integer.parseInt(productNumber)-1);
			cartService.addProductToCart(productToAdd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintToConsole.printString("Product was added to cart");
	}
}

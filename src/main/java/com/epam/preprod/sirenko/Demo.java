package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.containers.CommandContainer;
import com.epam.preprod.sirenko.dao.ProductDAO;

import java.io.*;

public class Demo {
	CommandContainer commandContainer;
	ProductDAO productDAO;
	
	public Demo() {
	}
	
	public Demo(CommandContainer commandContainer, ProductDAO productDAO) {
		this.commandContainer = commandContainer;
		this.productDAO = productDAO;
	}
	
	
	public static void main(String[] args) throws IOException {
		PrintToConsole.printString("Print 1 and press Enter to exit program");
		PrintToConsole.printString("Print 2 and press Enter to see all available products");
		PrintToConsole.printString("Print 3 and press Enter to add product to cart");
		PrintToConsole.printString("Print 4 and press Enter to see your cart");
		PrintToConsole.printString("Print 5 and press Enter to make an order");
		PrintToConsole.printString("Print 6 and press Enter to see 5 last added to cart products");
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.getAllProductsList();
		GetConsoleInput getConsoleInput = new GetConsoleInput();
		getConsoleInput.readFromConsole();
		

	}
}

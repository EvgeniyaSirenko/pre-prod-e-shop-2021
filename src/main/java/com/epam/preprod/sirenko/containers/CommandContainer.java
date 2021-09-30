package com.epam.preprod.sirenko.containers;

import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.command.ExitProgramCommand;
import com.epam.preprod.sirenko.command.GetProductsListCommand;
import com.epam.preprod.sirenko.command.NoCommandCommand;
import com.epam.preprod.sirenko.dao.ProductDAO;
import com.epam.preprod.sirenko.services.GetAllProductsListService;
import com.epam.preprod.sirenko.services.ProductService;

import java.util.HashMap;
import java.util.Map;

/**
 * All commands holder
 */
public class CommandContainer {
	
	private Map<Integer, Command> commands = new HashMap<>();
	
	private void init() {
		ProductDAO productDAO = new ProductDAO();
		//ProductService productService = new ProductService(productDAO);
		GetAllProductsListService getAllProductsList = new GetAllProductsListService(productDAO);
		GetProductsListCommand getProductsListCommand = new GetProductsListCommand(getAllProductsList);
		commands.put(2, getProductsListCommand);

		
		
		NoCommandCommand noCommandCommand = new NoCommandCommand();
		commands.put(0, noCommandCommand);
		
		System.out.println("init");
	}
	
	public Command get(Integer commandNumber) {
		if (commandNumber == null || !commands.containsKey(commandNumber)) {
			return commands.get(0);
		}
		return commands.get(commandNumber);
	}
	
	public Command getCommand(Integer commandNumber) {
		return commands.get(commandNumber);
	}
	
}

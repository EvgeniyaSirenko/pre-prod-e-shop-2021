package com.epam.preprod.sirenko.containers;

import com.epam.preprod.sirenko.command.*;
import com.epam.preprod.sirenko.command.impl.*;
import com.epam.preprod.sirenko.dao.CartDAO;
import com.epam.preprod.sirenko.dao.OrderDAO;
import com.epam.preprod.sirenko.dao.ProductDAO;
import com.epam.preprod.sirenko.services.CartService;
import com.epam.preprod.sirenko.services.OrderService;
import com.epam.preprod.sirenko.services.ProductService;

import java.util.HashMap;
import java.util.Map;

/**
 * All commands holder
 */
public class CommandContainer {

	private Map<String, Command> commands = new HashMap<>();
	
	public CommandContainer() {
		init();
	}
	
	private void init() {
		ProductDAO productDAO = new ProductDAO();
		ProductService productService = new ProductService(productDAO);
		GetProductsListCommand getProductsListCommand = new GetProductsListCommand(productService);
		commands.put("products", getProductsListCommand);
		NoCommandCommand noCommandCommand = new NoCommandCommand();
		commands.put("noCommand", noCommandCommand);
		ExitProgramCommand exitProgramCommand = new ExitProgramCommand();
		commands.put("out", exitProgramCommand);
		CartDAO cartDAO = new CartDAO();
		CartService cartService = new CartService(cartDAO);
		AddProductToCartCommand addProductToCartCommand = new AddProductToCartCommand(cartService, productService);
		commands.put("add", addProductToCartCommand);
		GetCartItemsCommand getCartItemsCommand = new GetCartItemsCommand(cartService);
		commands.put("cart", getCartItemsCommand);
		ShowMenuCommand showMenuCommand =  new ShowMenuCommand();
		commands.put("menu", showMenuCommand);
		OrderDAO orderDAO = new OrderDAO();
		OrderService orderService = new OrderService(orderDAO);
		MakeOrderCommand makeOrderCommand = new MakeOrderCommand(orderService, cartService);
		commands.put("order", makeOrderCommand);
		GetFiveProductsLastAddedToCartCommand getFiveProductsLastAddedToCartCommand = new GetFiveProductsLastAddedToCartCommand(cartService);
		commands.put("last5", getFiveProductsLastAddedToCartCommand);
		GetOrdersListOfCurrentPeriod getOrdersListOfCurrentPeriod = new GetOrdersListOfCurrentPeriod(orderService);
		commands.put("ordersList", getOrdersListOfCurrentPeriod);
		//orderDate
	}
	
	public Command getCommand(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			return commands.get("noCommand");
		}
		return commands.get(commandName);
	}
	
}

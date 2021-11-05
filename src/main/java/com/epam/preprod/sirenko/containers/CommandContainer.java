package com.epam.preprod.sirenko.containers;

import com.epam.preprod.sirenko.command.*;
import com.epam.preprod.sirenko.command.impl.*;
import com.epam.preprod.sirenko.dao.CartDAO;
import com.epam.preprod.sirenko.dao.OrderDAO;
import com.epam.preprod.sirenko.dao.ProductDAO;
import com.epam.preprod.sirenko.services.CartService;
import com.epam.preprod.sirenko.services.impl.SerializationServiceImpl;
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
		CartDAO cartDAO = new CartDAO();
		OrderDAO orderDAO = new OrderDAO();
		ProductService productService = new ProductService(productDAO);
		CartService cartService = new CartService(cartDAO);
		OrderService orderService = new OrderService(orderDAO);
		GetProductsListCommand getProductsListCommand = new GetProductsListCommand(productService);
		commands.put("products", getProductsListCommand);
		NoCommandCommand noCommandCommand = new NoCommandCommand();
		commands.put("noCommand", noCommandCommand);
		SerializationServiceImpl serializationServiceImpl = new SerializationServiceImpl(productDAO);
		ExitProgramCommand exitProgramCommand = new ExitProgramCommand(serializationServiceImpl);
		commands.put("out", exitProgramCommand);
		AddProductToCartCommand addProductToCartCommand = new AddProductToCartCommand(cartService, productService);
		commands.put("add", addProductToCartCommand);
		GetCartItemsCommand getCartItemsCommand = new GetCartItemsCommand(cartService);
		commands.put("cart", getCartItemsCommand);
		ShowMenuCommand showMenuCommand =  new ShowMenuCommand();
		commands.put("menu", showMenuCommand);
		MakeOrderCommand makeOrderCommand = new MakeOrderCommand(orderService, cartService);
		commands.put("order", makeOrderCommand);
		GetProductsLastAddedToCartCommand getFiveProductsLastAddedToCartCommand = new GetProductsLastAddedToCartCommand(cartService);
		commands.put("last5", getFiveProductsLastAddedToCartCommand);
		GetOrdersListOfCurrentPeriodCommand getOrdersListOfCurrentPeriodCommand = new GetOrdersListOfCurrentPeriodCommand(orderService);
		commands.put("ordersList", getOrdersListOfCurrentPeriodCommand);
		GetOrderClosestToGivenDateCommand getOrderClosestToGivenDateCommand = new GetOrderClosestToGivenDateCommand(orderService);
		commands.put("orderDate", getOrderClosestToGivenDateCommand);
	}
	
	public Command getCommand(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			return commands.get("noCommand");
		}
		return commands.get(commandName);
	}
	
}

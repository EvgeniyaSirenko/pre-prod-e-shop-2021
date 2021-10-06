package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.ConsoleReader;
import com.epam.preprod.sirenko.PrintToConsole;
import com.epam.preprod.sirenko.Util;
import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.services.CartService;
import com.epam.preprod.sirenko.services.OrderService;

import java.io.IOException;
import java.sql.Timestamp;

public class MakeOrderCommand implements Command {
	private OrderService orderService;
	private CartService cartService;
	
	public MakeOrderCommand(OrderService orderService, CartService cartService) {
		this.orderService = orderService;
		this.cartService = cartService;
	}
	
	@Override
	public void execute() {
		PrintToConsole.printString("Print date in format 2021-09-23 13:45:00 and press Enter");
		Util util = new Util();
		try {
			String date = ConsoleReader.readFromConsole();
			Timestamp creationDate = util.convertStringToTimestamp(date);
			if (date == null || creationDate == null) {
				PrintToConsole.printString("Print date in format 2021-09-23 13:45:00 and press Enter");
				return;
			}
			orderService.makeOrder(creationDate, cartService.getCartItems());
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintToConsole.printString("Order was made");
		PrintToConsole.printString("Total amount of the order is: ");
		PrintToConsole.printBigDecimal(cartService.getOrderTotalPrice());
		cartService.clearCart();
	}
}

package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.ConsoleReader;
import com.epam.preprod.sirenko.PrintToConsole;
import com.epam.preprod.sirenko.Util;
import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.services.OrderService;

import java.io.IOException;
import java.sql.Timestamp;

public class GetOrderClosestToGivenDateCommand implements Command {
	private OrderService orderService;
	
	public GetOrderClosestToGivenDateCommand(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public void execute() {
		PrintToConsole.printString("Print date to search in format 2021-09-23 13:45:00 and press Enter");
		Util util = new Util();
		try {
			String dateString = ConsoleReader.readFromConsole();
			Timestamp date = util.convertStringToTimestamp(dateString);
			if (date == null || dateString == null) {
				PrintToConsole.printString("Print date in format 2021-09-23 13:45:00 and press Enter");
				return;
			}
			if (orderService.getOrdersClosestToDate(date) == null) {
				PrintToConsole.printString("No orders found");
			} else {
				PrintToConsole.printCartMap(orderService.getOrdersClosestToDate(date));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

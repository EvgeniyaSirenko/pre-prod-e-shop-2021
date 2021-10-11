package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.ConsoleReader;
import com.epam.preprod.sirenko.PrintToConsole;
import com.epam.preprod.sirenko.util.ConverterToTimestamp;
import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.services.OrderService;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * This class prints to console instructions, waits for input date
 * to call orderService for getting closest to that date order
 */
public class GetOrderClosestToGivenDateCommand implements Command {
	private OrderService orderService;
	
	public GetOrderClosestToGivenDateCommand(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public void execute() {
		PrintToConsole.printString("Print date to search in format 2021-09-23 13:45:00 and press Enter");
		try {
			String dateString = ConsoleReader.readFromConsole();
			Timestamp date = ConverterToTimestamp.convertStringToTimestamp(dateString);
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

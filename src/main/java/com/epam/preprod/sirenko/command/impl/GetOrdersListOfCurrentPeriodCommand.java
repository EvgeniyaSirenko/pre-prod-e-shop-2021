package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.ConsoleReader;
import com.epam.preprod.sirenko.PrintToConsole;
import com.epam.preprod.sirenko.Util;
import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.services.OrderService;

import java.io.IOException;
import java.sql.Timestamp;

public class GetOrdersListOfCurrentPeriodCommand implements Command {
	private OrderService orderService;
	
	public GetOrdersListOfCurrentPeriodCommand(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public void execute() {
		PrintToConsole.printString("Print from what date to search in format 2021-09-23 13:45:00 and press Enter");
		Util util = new Util();
		try {
			String dateFromString = ConsoleReader.readFromConsole();
			Timestamp dateFrom = util.convertStringToTimestamp(dateFromString);
			if (dateFrom == null || dateFromString == null) {
				PrintToConsole.printString("Print date in format 2021-09-23 13:45:00 and press Enter");
				return;
			}
			PrintToConsole.printString("Print to what date to search in format 2021-09-23 13:45:00 and press Enter");
			String dateToString = ConsoleReader.readFromConsole();
			Timestamp dateTo = util.convertStringToTimestamp(dateToString);
			if (dateToString == null || dateTo == null) {
				PrintToConsole.printString("Print date in format 2021-09-23 13:45:00 and press Enter");
				return;
			}
			PrintToConsole.printOrderMap(orderService.getOrdersListOfCurrentPeriod(dateFrom, dateTo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

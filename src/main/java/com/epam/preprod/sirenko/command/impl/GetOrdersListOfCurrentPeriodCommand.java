package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.util.ConsoleReader;
import com.epam.preprod.sirenko.util.PrintToConsole;
import com.epam.preprod.sirenko.util.ConsoleInputTimestampManager;
import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.services.OrderService;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * This class prints to console instructions, waits for input dates
 * to call orderService for getting list of orders of that period
 */
public class GetOrdersListOfCurrentPeriodCommand implements Command {
	private OrderService orderService;
	
	public GetOrdersListOfCurrentPeriodCommand(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public void execute() {
		try {
			Timestamp dateFrom = getTimestamp("Print from what date to search in format 2021-09-23 13:45:00 and press Enter");
			Timestamp dateTo = getTimestamp("Print to what date to search in format 2021-09-23 13:45:00 and press Enter");
			if (dateFrom.compareTo(dateTo) >= 0) {
				PrintToConsole.printString("This date has to be later then the first date you printed");
				return;
			}
			PrintToConsole.printOrderMap(orderService.getOrdersListOfCurrentPeriod(dateFrom, dateTo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Timestamp getTimestamp(String message) throws IOException {
		PrintToConsole.printString(message);
		ConsoleReader consoleReader = new ConsoleReader();
		String dateString = consoleReader.readFromConsole();
		return ConsoleInputTimestampManager.manageTimestamp(dateString);
	}
}

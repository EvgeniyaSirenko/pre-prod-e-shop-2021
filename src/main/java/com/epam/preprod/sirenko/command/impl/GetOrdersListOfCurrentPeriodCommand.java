package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.ConsoleReader;
import com.epam.preprod.sirenko.PrintToConsole;
import com.epam.preprod.sirenko.util.ConverterToTimestamp;
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
				PrintToConsole.printString("To wat date need to be after from what date");
				return;
			}
			PrintToConsole.printOrderMap(orderService.getOrdersListOfCurrentPeriod(dateFrom, dateTo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Timestamp getTimestamp(String message) throws IOException {
		PrintToConsole.printString(message);
		String dateString = ConsoleReader.readFromConsole();
		return ConverterToTimestamp.convertStringToTimestamp(dateString);
	}
}

package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.services.OrderService;

public class GetOrdersListOfCurrentPeriod implements Command {
	private OrderService orderService;
	
	public GetOrdersListOfCurrentPeriod(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public void execute() {
	
	}
}

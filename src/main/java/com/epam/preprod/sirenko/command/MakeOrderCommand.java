package com.epam.preprod.sirenko.command;

import com.epam.preprod.sirenko.PrintToConsole;
import com.epam.preprod.sirenko.services.CartService;
import com.epam.preprod.sirenko.services.OrderService;

public class MakeOrderCommand implements Command {
	OrderService orderService;
	CartService cartService;
	
	public MakeOrderCommand(OrderService orderService, CartService cartService) {
		this.orderService = orderService;
		this.cartService = cartService;
	}
	
	@Override
	public void execute() {
		orderService.makeOrder(cartService.getCartItems());
		cartService.clearCart();
		PrintToConsole.printString("Total amount of the order is: ");
		PrintToConsole.printBigDecimal(orderService.countAmount());
	}
}

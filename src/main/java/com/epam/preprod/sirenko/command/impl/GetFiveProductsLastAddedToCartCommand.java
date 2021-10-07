package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.PrintToConsole;
import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.services.CartService;

public class GetFiveProductsLastAddedToCartCommand implements Command {
	private CartService cartService;
	
	public GetFiveProductsLastAddedToCartCommand(CartService cartService) {
		this.cartService = cartService;
	}
	
	@Override
	public void execute() {
		PrintToConsole.printCartMap(cartService.getMaxEntriesLastAddedToCart());
	}
}

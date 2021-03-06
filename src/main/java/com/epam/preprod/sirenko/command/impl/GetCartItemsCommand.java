package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.util.PrintToConsole;
import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.services.CartService;

/**
 * This class calls productService to get cart items
 */
public class GetCartItemsCommand implements Command {
	private CartService cartService;
	
	public GetCartItemsCommand(CartService cartService) {
		this.cartService = cartService;
	}
	
	@Override
	public void execute() {
		PrintToConsole.printCartMap(cartService.getCartItems());
	}
}

package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.util.PrintToConsole;
import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.services.CartService;

/**
 * This class calls cartService to print to console products last added to cart
 */
public class GetProductsLastAddedToCartCommand implements Command {
	private CartService cartService;
	
	public GetProductsLastAddedToCartCommand(CartService cartService) {
		this.cartService = cartService;
	}
	
	@Override
	public void execute() {
		PrintToConsole.printCartMap(cartService.getProductsLastAddedToCart());
	}
}

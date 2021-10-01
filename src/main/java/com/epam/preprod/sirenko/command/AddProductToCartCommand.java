package com.epam.preprod.sirenko.command;

import com.epam.preprod.sirenko.services.CartService;

public class AddProductToCartCommand implements Command {
	CartService cartService;
	
	public AddProductToCartCommand(CartService cartService) {
		this.cartService = cartService;
	}
	
	@Override
	public void execute() {
		cartService.addProductToCart();
	}
}

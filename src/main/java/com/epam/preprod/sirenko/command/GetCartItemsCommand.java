package com.epam.preprod.sirenko.command;

import com.epam.preprod.sirenko.services.CartService;

public class GetCartItemsCommand implements Command {
	CartService cartService;
	
	public GetCartItemsCommand(CartService cartService) {
		this.cartService = cartService;
	}
	
	@Override
	public void execute() {
		cartService.getCartItems();
	}
}

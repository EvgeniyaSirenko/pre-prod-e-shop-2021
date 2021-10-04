package com.epam.preprod.sirenko.command;

import com.epam.preprod.sirenko.PrintToConsole;

public class ShowMenuCommand implements Command{
	
	@Override
	public void execute() {
		PrintToConsole.printString("--------------------------------------------------");
		PrintToConsole.printString("Print out and press Enter to exit program");
		PrintToConsole.printString("Print products and press Enter to see all available products");
		PrintToConsole.printString("Print add and press Enter to add product to cart");
		PrintToConsole.printString("Print cart and press Enter to see your cart");
		PrintToConsole.printString("Print order and press Enter to make an order");
		PrintToConsole.printString("Print last5 and press Enter to see 5 last added to cart products");
		PrintToConsole.printString("--------------------------------------------------");
	}
}

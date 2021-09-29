package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.command.ExitProgramCommand;
import com.epam.preprod.sirenko.command.GetProductsListCommand;

import java.io.*;

public class Demo {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Print 0 and press Enter to exit program");
		System.out.println("Print 1 and press Enter to see all available products");
		System.out.println("Print 2 and press Enter to add product to cart");
		System.out.println("Print 3 and press Enter to see your cart");
		System.out.println("Print 4 and press Enter to make an order");
		System.out.println("Print 5 and press Enter to see 5 last added to cart products");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			int commandKey = Integer.parseInt(bufferedReader.readLine());
			if (commandKey == 0) {
				ExitProgramCommand exit = new ExitProgramCommand();
				exit.execute();
			}
			if (commandKey == 1) {
				GetProductsListCommand getProducts = new GetProductsListCommand();
				System.out.println(getProducts.execute());
			}
		}

	}
}

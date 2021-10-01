package com.epam.preprod.sirenko.command;

import com.epam.preprod.sirenko.PrintToConsole;

public class NoCommandCommand implements Command {
	
	@Override
	public void execute() {
		PrintToConsole.printString("No such command, enter another key");
	}
}

package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.PrintToConsole;
import com.epam.preprod.sirenko.command.Command;

/**
 * This class prints to console message that there is no such command
 */
public class NoCommandCommand implements Command {
	
	@Override
	public void execute() {
		PrintToConsole.printString("No such command, enter another key");
	}
}

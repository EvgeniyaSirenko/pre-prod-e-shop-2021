package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.util.PrintToConsole;
import com.epam.preprod.sirenko.command.Command;

/**
 * This class prints to console message that program is stopped
 */
public class ExitProgramCommand implements Command {

	@Override
	public void execute() {
		PrintToConsole.printString("Program is stopped");
	}
}

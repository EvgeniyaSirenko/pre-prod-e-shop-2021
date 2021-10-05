package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.PrintToConsole;
import com.epam.preprod.sirenko.command.Command;

public class ExitProgramCommand implements Command {

	@Override
	public void execute() {
		PrintToConsole.printString("Program is stopped");
	}
}

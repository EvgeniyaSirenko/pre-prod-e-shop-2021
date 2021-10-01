package com.epam.preprod.sirenko.command;

import com.epam.preprod.sirenko.PrintToConsole;

public class ExitProgramCommand implements Command {

	@Override
	public void execute() {
		PrintToConsole.printString("Program is stopped");
	}
}

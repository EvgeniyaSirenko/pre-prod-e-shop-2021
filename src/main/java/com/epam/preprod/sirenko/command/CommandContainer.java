package com.epam.preprod.sirenko.command;

import java.util.Map;
import java.util.TreeMap;

/**
 * All commands holder
 */
public class CommandContainer {
	private static Map<String, Command> commands = new TreeMap<>();
	
	static {
		commands.put("exit", new ExitProgramCommand());
	}
	
	public static Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			return commands.get("noCommand");
		}
		return commands.get(commandName);
	}
	
	public static Command getCommand(String commandName) {
		return commands.get(commandName);
	}

}

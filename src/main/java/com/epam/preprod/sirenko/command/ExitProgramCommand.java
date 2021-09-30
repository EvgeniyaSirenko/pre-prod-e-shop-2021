package com.epam.preprod.sirenko.command;

import com.epam.preprod.sirenko.entity.Product;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;

public class ExitProgramCommand implements Command {
	//TODO
	@Override
	public void execute() {
		try (Socket socket = new Socket()) {
			socket.shutdownInput();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException();//this is wrong
	}
}

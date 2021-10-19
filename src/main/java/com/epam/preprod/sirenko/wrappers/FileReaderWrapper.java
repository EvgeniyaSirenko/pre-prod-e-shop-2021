package com.epam.preprod.sirenko.wrappers;

import com.epam.preprod.sirenko.util.PrintToConsole;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class reads text files
 */
public class FileReaderWrapper implements Iterable {
	private String fileName;
	
	public FileReaderWrapper(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			this.fileName = fileName;
		} else {
			throw new NoSuchElementException("No such file found");
		}
	}
	
	@Override
	public Iterator iterator() {
		return new FileReaderIterator();
	}
	
	private class FileReaderIterator implements Iterator {
		private BufferedReader bufferedReader;
		
		{
			try {
				bufferedReader = new BufferedReader(new FileReader(fileName));
			} catch (FileNotFoundException e) {
				PrintToConsole.printString("No such file found");
			}
		}
		
		@Override
		public boolean hasNext() {
			try {
				if (bufferedReader.ready()) {
					return true;
				}
			} catch (IOException e) {
				throw new IllegalArgumentException();
			}
			return false;
		}
		
		@Override
		public String next() {
			String nextLine;
			try {
				nextLine = bufferedReader.readLine();
				
			} catch (IOException e) {
				throw new IllegalArgumentException();
			}
			return nextLine;
		}
	}
}

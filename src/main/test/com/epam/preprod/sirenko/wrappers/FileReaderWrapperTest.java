package com.epam.preprod.sirenko.wrappers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderWrapperTest {
	File file;
	BufferedWriter bufferedWriter;
	
	@BeforeEach
	public void setData() throws IOException {
		file = new File("test.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));
		bufferedWriter.append("if you want to drink beer");
		bufferedWriter.append(System.lineSeparator());
		bufferedWriter.append("I recommend to go to Germany");
		bufferedWriter.append(System.lineSeparator());
		bufferedWriter.append("for example to Cologne");
		bufferedWriter.close();
	}
	
	@AfterEach
	public void deleteData() {
		//file.delete() or deleteOnExit didn't work
		Path path = Path.of(file.getPath());
		Files.delete(path);
	}

	@Test
	void testFileReaderWrapperShouldThrowExceptionWhenFileNotExist() {
		Throwable exception = assertThrows(NoSuchElementException.class, () -> {
			new FileReaderWrapper("myText.txt");
		});
		assertEquals("No such file found", exception.getMessage());
	}
	
	@Test
	void testIteratorWithForEachShouldPrintAllLinesOfFile() {
		FileReaderWrapper fileReaderWrapper = new FileReaderWrapper("test.txt");
		List<String> listOfFileLines = new ArrayList<>();
		
		for (Object line : fileReaderWrapper) {
			listOfFileLines.add((String) line);
		}
		
		assertEquals("if you want to drink beer", listOfFileLines.get(0));
		assertEquals("I recommend to go to Germany", listOfFileLines.get(1));
		assertEquals("for example to Cologne", listOfFileLines.get(2));
	}

}
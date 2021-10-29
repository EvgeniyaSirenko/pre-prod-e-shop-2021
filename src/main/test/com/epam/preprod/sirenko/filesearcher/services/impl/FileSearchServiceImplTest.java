package com.epam.preprod.sirenko.filesearcher.services.impl;

import com.epam.preprod.sirenko.filesearcher.filters.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchServiceImplTest {
	private String startDirectory;
	private static final String FIRST_FILE = "text.txt";
	private static final String SECOND_FILE = "pic.txt";
	private static final String THIRD_FILE = "text.md";
	private File firstFile;
	private File secondFile;
	private File thirdFile;
	private FileSearchServiceImpl fileSearchServiceImpl;
	private String notExistingFile;
	private String inputName;
	private String inputExtension;
	private String inputSizeRange;
	private String inputEditDateRange;
	List<File> list;
	private BufferedWriter bufferedWriter;
	private Filter filter;
	RequestBuilder requestBuilder;
	
	@BeforeEach
	public void setData() throws IOException {
		startDirectory = "/Users/evgeniya/Desktop/test1";
		firstFile = new File(startDirectory, FIRST_FILE);
		secondFile = new File(startDirectory, SECOND_FILE);
		thirdFile = new File(startDirectory, THIRD_FILE);
		bufferedWriter = new BufferedWriter(new FileWriter(firstFile));
		setUpFiles();
		setupWriter();
		notExistingFile = "nope";
		inputName = "text";
		inputExtension = "txt";
		inputSizeRange = "1 5";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateFrom = dateFormat.format(new Date(System.currentTimeMillis() - 700 * 1000));
		String dateTo = dateFormat.format(new Date(System.currentTimeMillis() - 180 * 1000));
		inputEditDateRange = dateFrom + " " + dateTo;
		requestBuilder = new RequestBuilder();
	}
	
	private void setUpFiles() throws IOException {
		if (!firstFile.exists()) {
			firstFile.createNewFile();
		}
		if (!secondFile.exists()) {
			secondFile.createNewFile();
		}
		if (!thirdFile.exists()) {
			thirdFile.createNewFile();
		}
		firstFile.deleteOnExit();
		secondFile.deleteOnExit();
		thirdFile.deleteOnExit();
	}
	
	private void setupWriter() throws IOException {
		for (int i = 0; i < 50; i++) {
			bufferedWriter.append("Some text to make this file bigger then zero bytes");
			bufferedWriter.append(System.lineSeparator());
		}
		bufferedWriter.close();
	}
	
	@Test
	void chainBuilderShouldReturnEmptyListIfMatchingFilesNotFound() {
		filter = new FilterByFileName(notExistingFile);
		fileSearchServiceImpl = new FileSearchServiceImpl(filter);
		list = fileSearchServiceImpl.fileSearch(new File(startDirectory));
		
		assertEquals(0, list.size());
	}
	
	@Test
	void fileSearchShouldReturnListOfFoundByNameFiles() {
		filter = new FilterByFileName(inputName);
		fileSearchServiceImpl = new FileSearchServiceImpl(filter);
		
		list = fileSearchServiceImpl.fileSearch(new File(startDirectory));
		
		assertEquals(2, list.size());
		assertEquals("text.md", list.get(0).getName());
		assertEquals("text.txt", list.get(1).getName());
	}
	
	@Test
	void fileSearchShouldReturnListOfFoundByExtensionFiles() {
		filter = new FilterByExtension(inputExtension);
		fileSearchServiceImpl = new FileSearchServiceImpl(filter);
		
		list = fileSearchServiceImpl.fileSearch(new File(startDirectory));
		
		assertEquals(2, list.size());
		assertEquals("pic.txt", list.get(0).getName());
		assertEquals("text.txt", list.get(1).getName());
	}
	
	@Test
	void fileSearchShouldReturnListOfFoundBySizeFiles() {
		filter = new FilterBySize(inputSizeRange);
		fileSearchServiceImpl = new FileSearchServiceImpl(filter);
		
		list = fileSearchServiceImpl.fileSearch(new File(startDirectory));
		
		assertEquals(1, list.size());
		assertEquals("text.txt", list.get(0).getName());
	}
	
	@Test
	void fileSearchShouldReturnListOfFoundByLastEditDateFiles() {
		filter = new FilterByEditDate(inputEditDateRange);
		fileSearchServiceImpl = new FileSearchServiceImpl(filter);
		Date newDate = new Date(System.currentTimeMillis() - 600 * 1000);
		thirdFile.setLastModified(newDate.getTime());
		
		list = fileSearchServiceImpl.fileSearch(new File(startDirectory));
		
		assertEquals(1, list.size());
		assertEquals("text.md", list.get(0).getName());
	}
	
	@Test
	void fileSearchShouldReturnEmptyListIfFileNotFoundInChain() {
		filter = requestBuilder.firstQuestion(notExistingFile);
		fileSearchServiceImpl = new FileSearchServiceImpl(filter);
		
		list = fileSearchServiceImpl.fileSearch(new File(startDirectory));
		
		assertEquals(0, list.size());
	}
	
	@Test
	void fileSearchShouldReturnListFoundInAllChain() {
		filter = requestBuilder.firstQuestion(inputName);
		fileSearchServiceImpl = new FileSearchServiceImpl(filter);
		Date newDate = new Date(System.currentTimeMillis() - 600 * 1000);
		firstFile.setLastModified(newDate.getTime());
		
		list = fileSearchServiceImpl.fileSearch(new File(startDirectory));
		
		assertEquals(1, list.size());
		assertEquals("text.txt", list.get(0).getName());
		assertEquals(2550, list.get(0).length());
	}
	
	private class RequestBuilder {
		
		private Filter firstQuestion(String fileName) {
			filter = new FilterByFileName(fileName);
			return secondQuestion(filter);
		}
		
		private Filter secondQuestion(Filter filter) {
			filter.setNextFilter(new FilterByExtension(inputExtension));
			return thirdQuestion(filter);
		}
		
		private Filter thirdQuestion(Filter filter) {
			filter.setNextFilter(new FilterBySize(inputSizeRange));
			return fourthQuestion(filter);
		}
		
		private Filter fourthQuestion(Filter filter) {
			filter.setNextFilter(new FilterByEditDate(inputEditDateRange));
			return filter;
		}
	}
}